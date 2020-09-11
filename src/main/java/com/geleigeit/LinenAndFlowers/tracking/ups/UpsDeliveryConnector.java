package com.geleigeit.LinenAndFlowers.tracking.ups;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.geleigeit.LinenAndFlowers.entity.enums.Role;
import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.security.SecurityUser;
import com.geleigeit.LinenAndFlowers.service.impl.DeliveryServiceImpl;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import com.geleigeit.LinenAndFlowers.service.impl.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UpsDeliveryConnector {
//
//    @Value("${ups.url}")
//    private String URL;
//    @Value("${ups.accesskey}")
//    private String ACCESSKEY;
//
//    private final UserService userService;
//    private final OrderService orderService;
//    private final DeliveryServiceImpl deliveryServiceImpl;
//    private final OrderStatusService orderStatusService;
//
//    private List<Order> orders = new ArrayList<>();
//
//    private static final Logger logger = LogManager.getLogger(UpsDeliveryConnector.class);
//
//    @Autowired
//    public UpsDeliveryConnector(UserService userService,
//                                OrderService orderService,
//                                DeliveryServiceImpl deliveryServiceImpl,
//                                OrderStatusService orderStatusService) {
//        this.userService = userService;
//        this.orderService = orderService;
//        this.deliveryServiceImpl = deliveryServiceImpl;
//        this.orderStatusService = orderStatusService;
//    }

//    @Transactional
//    @Scheduled(fixedDelay=(60 * 60 * 1000))
//    public void updateTrackingInformation() {
//        long scheduleUserId = 2;
//        long deliveryStatus = 3;//orderStatusService.findByStatusGetId("IN_DELIVERY");
//        long deliveryCompany = 3;//deliveryServiceImpl.findByNameGetId("UPS");

//        orders = orderService.getAllByOrderStatusIdAndDeliveryServiceId(3, 3);

        //authentication user 'Schedule'
//        Authentication auth = new UsernamePasswordAuthenticationToken(SecurityUser.fromUser(
//                userService.getUser(scheduleUserId)), Role.ADMIN);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        for(Order order : orders) {
//            try {
//                orderService.update(parser(order));
//            } catch (IOException exception) {
//                logger.error("cannot parse json");
//                exception.printStackTrace();
//            }
//
//        }
//    }
//
//    private Order parser(Order order) throws IOException {
//
//        String json = getResponse(order.getTrackingCode());
//
//        OrderTracking orderTracking = new OrderTracking();
//        StringBuffer strBuffer = new StringBuffer();
//        //parse json
//        JsonFactory jfactory = new JsonFactory();
//        JsonParser jParser = jfactory.createParser(json);

//        while (jParser.nextToken() != JsonToken.END_ARRAY) {
//            String fieldName = jParser.getCurrentName();
//            if ("trackingNumber".equals(fieldName)) {
//                jParser.nextToken();
//                orderTracking.setTrackingCode(jParser.getText());
//            }
//
//            if ("description".equals(fieldName)) {
//                jParser.nextToken();
//                orderTracking.setDescription(jParser.getText());
//            }
//
//            if ("date".equals(fieldName)) {
//                jParser.nextToken();
//                strBuffer.insert(0, jParser.getText());
//            }
//
//            if ("time".equals(fieldName)) {
//                jParser.nextToken();
//                strBuffer.append(jParser.getText());
//            }
//
//            if ("city".equals(fieldName)) {
//                jParser.nextToken();
//                orderTracking.setCurrentCity(jParser.getText());
//            }
//
//            if ("country".equals(fieldName)) {
//                jParser.nextToken();
//                orderTracking.setCurrentCountry(jParser.getText());
//            }
//        }
//        jParser.close();
        //parse date and time from String to Date
//        orderTracking.setDate(convertStringToDate(strBuffer));
        //add orderTrackingClass to Order
//        order.getOrderTracking().add(orderTracking);
//        return order;
//    }

//    private String getResponse(String trackingNumber) {
////        headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(URL, ACCESSKEY);
//        HttpEntity<String> request = new HttpEntity<>(headers);
//        //url
//        String url = URL +trackingNumber;
//        //get response
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
//        //get String json from response
//        return responseEntity.getBody();
//    }

//    private Date convertStringToDate(StringBuffer strBuffer) {
//        String string = strBuffer.toString();
//        try {
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//            return format.parse(string);
//        } catch (ParseException exception) {
//            logger.error("cannot parse stringBuffer");
//            exception.printStackTrace();
//        }
//        return null;
//    }
}
