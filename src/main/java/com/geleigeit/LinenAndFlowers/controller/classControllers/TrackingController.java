package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderTrackingService;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/tracking")
public class TrackingController {

    private final OrderService orderService;
    private final OrderStatusService orderStatusService;
    private final OrderTrackingService orderTrackingService;
    private final long inDeliveryStatus = 3;
    private static final Logger logger = LogManager.getLogger(TrackingController.class);

    @Autowired
    public TrackingController(OrderService orderService,
                              OrderStatusService orderStatusService, OrderTrackingService orderTrackingService) {
        this.orderService = orderService;
        this.orderStatusService = orderStatusService;
        this.orderTrackingService = orderTrackingService;
    }

//    @Transactional
//    @RequestMapping(value = "/{delivery_service_id:.+}", method = RequestMethod.GET)
//    List<Order> getAllByDeliveryService(@PathVariable("delivery_service_id") long deliveryServiceId) {
}