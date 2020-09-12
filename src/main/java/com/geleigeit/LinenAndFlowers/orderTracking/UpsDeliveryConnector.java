package com.geleigeit.LinenAndFlowers.orderTracking;

import com.geleigeit.LinenAndFlowers.entity.enums.Role;
import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.security.SecurityUser;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderTrackingService;
import com.geleigeit.LinenAndFlowers.service.impl.UserService;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class UpsDeliveryConnector implements Trackable {

    private final OrderService orderService;
    private final OrderStatusService orderStatusService;
    private final OrderTrackingService orderTrackingService;
    private final UserService userService;
    private final long inDeliveryStatus = 3;
    private final long deliveryServiceId = 3;
    private static final Logger logger = LogManager.getLogger(UpsDeliveryConnector.class);

    public UpsDeliveryConnector(OrderService orderService,
                                OrderStatusService orderStatusService,
                                OrderTrackingService orderTrackingService, UserService userService) {
        this.orderService = orderService;
        this.orderStatusService = orderStatusService;
        this.orderTrackingService = orderTrackingService;
        this.userService = userService;
    }

    @Scheduled(cron = "0 0 11,18 * * *")
    public void getAllByDeliveryService() {

        long scheduleId = 2;
        List<Order> orders = orderService.getAllByOrderStatusIdAndDeliveryServiceId(inDeliveryStatus, deliveryServiceId);

        Authentication auth = new UsernamePasswordAuthenticationToken(SecurityUser.fromUser(
                userService.getUser(scheduleId)), Role.ADMIN);
        SecurityContextHolder.getContext().setAuthentication(auth);

        for(Order order : orders) {
            try {
                orderService.update(parser(order));
            } catch (PathNotFoundException e) {
                logger.info("package {} still in delivery", order.getTrackingCode());
            }
        }
    }

    public Order getOneByOrderId(long id) {

        Order order = orderService.getOneByOrderStatusIdAndDeliveryServiceIdAndId(inDeliveryStatus, deliveryServiceId, id);
            try {
                orderService.update(parser(order));
            } catch (PathNotFoundException e) {
                logger.info("package {} still in delivery", order.getTrackingCode());
            }
        return null;
    }

    public Order parser(Order order) throws PathNotFoundException{

        String deliveredMark = "DEL";
        String json = getJson(order.getTrackingCode());
        OrderTracking orderTracking = new OrderTracking();

        //parse json
        String isDelivered = JsonPath.read(json, "$.trackResponse.shipment[0].package[0].deliveryDate[0].type");
        orderTracking.setTrackingCode(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].trackingNumber"));
        orderTracking.setDescription(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].status.description"));
        orderTracking.setCurrentCountry(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].location.address.country"));
        orderTracking.setCurrentCity(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].location.address.city"));
        String date = JsonPath.read(json,"$.trackResponse.shipment[0]package[0]activity[0]date");
        String time = JsonPath.read(json,"$.trackResponse.shipment[0]package[0]activity[0]time");
        Date dateToSet = convertStringToDate(normalizeString(date, time));
        orderTracking.setDate(dateToSet);

        if(isDelivered.equals(deliveredMark)) {
            order.setOrderStatus(orderStatusService.getOrderStatusByName("DELIVERED"));
            order.setArrivalDate(dateToSet);
        }

        orderTracking.setOrder(order);
        order.getOrderTracking().add(orderTracking);
        orderTrackingService.addOne(orderTracking);
        return order;
    }

    public String getJson(String trackingNumber) {

        String URL = "https://onlinetools.ups.com/track/v1/details/" + trackingNumber;
        final String ACCESSKEY = "7D874B3DE6305751";

        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("AccessLicenseNumber", ACCESSKEY);
        HttpEntity<String> request = new HttpEntity<>(headers);

        //get response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, request, String.class);
        return responseEntity.getBody();
    }

    public Date convertStringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            logger.error("cannot parse the string {}", date );
        }
        return null;
    }

    public String normalizeString(String date, String time) {

        final String dash = "-";
        final String colon = ":";
        final String space = " ";

        return date.substring(0, 4) +
                dash +
                date.substring(4, 6) +
                dash +
                date.substring(6) +
                space +
                time.substring(0, 2) +
                colon +
                time.substring(2, 4) +
                colon +
                time.substring(4);
    }
}