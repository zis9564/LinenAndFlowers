package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.service.impl.*;
import com.geleigeit.LinenAndFlowers.tracking.ups.UpsDeliveryConnector;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/tracking")
public class TrackingController {

//    @Value("${ups.url}")
    private String URL = "https://onlinetools.ups.com/track/v1/details/";
//    @Value("${ups.accesskey}")
    private String ACCESSKEY = "7D874B3DE6305751";

    private final UserService userService;
    private final OrderService orderService;
    private final DeliveryServiceImpl deliveryServiceImpl;
    private final OrderStatusService orderStatusService;
    private final OrderTrackingService orderTrackingService;

    private static final Logger logger = LogManager.getLogger(UpsDeliveryConnector.class);

    public TrackingController(UserService userService,
                              OrderService orderService,
                              DeliveryServiceImpl deliveryServiceImpl,
                              OrderStatusService orderStatusService, OrderTrackingService orderTrackingService) {
        this.userService = userService;
        this.orderService = orderService;
        this.deliveryServiceImpl = deliveryServiceImpl;
        this.orderStatusService = orderStatusService;
        this.orderTrackingService = orderTrackingService;
    }

    @GetMapping
    @Transactional
    List<Order> getAll() {

        List<Order> orders = orderService.getAllByOrderStatusIdAndDeliveryServiceId(3, 3);

        for(Order order : orders) {
            try {
                orderService.update(parser(order));
            } catch (PathNotFoundException e) {
                logger.info("package {} still in delivery", order.getTrackingCode());
            }
        }
        return orders;
    }

    private Order parser(Order order) throws PathNotFoundException{

        String json = getJson(order.getTrackingCode());
        OrderTracking orderTracking = new OrderTracking();

        //parse json
//        String deliveryTime = JsonPath.read(json, "$.trackResponse.shipment[0].package[0].deliveryTime.endTime");
        orderTracking.setTrackingCode(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].trackingNumber"));
        orderTracking.setDescription(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].status.description"));
        orderTracking.setCurrentCountry(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].location.address.country"));
        orderTracking.setCurrentCity(JsonPath.read(json,"$.trackResponse.shipment[0].package[0].activity[0].location.address.city"));
        String date = JsonPath.read(json,"$.trackResponse.shipment[0]package[0]activity[0]date");
        String time = JsonPath.read(json,"$.trackResponse.shipment[0]package[0]activity[0]time");
        try {
            orderTracking.setDate(convertStringToDate(date, time));
        } catch (ParseException e) {
            logger.error("cannot parse the date {}", date + time);
        }

//        if(deliveryTime != null) {
//            order.setArrivalDate(convertStringToDate(date, deliveryTime));
//            order.setOrderStatus(orderStatusService.getOrderStatusByName("DELIVERED"));
//        }
        orderTracking.setOrder(order);
        order.getOrderTracking().add(orderTracking);

        orderTrackingService.addOne(orderTracking);
//        orderService.update(order);

        return order;
    }

    private String getJson(String trackingNumber) {
        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("AccessLicenseNumber", "7D874B3DE6305751");
        HttpEntity<String> request = new HttpEntity<>(headers);
        //url
        String url = URL +trackingNumber;
        //get response
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        //get String json from response
        return responseEntity.getBody();
    }

    private Date convertStringToDate(String date, String time) throws ParseException {
        String string = date+time;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string);
    }
}
