package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderTrackingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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