package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.controller.abstractControllers.GetMethodsAbstractController;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.service.impl.OrderTrackingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("api/tracking")
public class OrderTrackingController extends GetMethodsAbstractController<OrderTracking, OrderTrackingService> {

    private final OrderTrackingService orderTrackingService;
    private static final Logger logger = LogManager.getLogger(OrderTrackingController.class);

    @Autowired
    protected OrderTrackingController(OrderTrackingService service, OrderTrackingService orderTrackingService) {
        super(service);
        this.orderTrackingService = orderTrackingService;
    }

    @Override
    public OrderTracking getOne(long id) {
        final OrderTracking orderTracking;
        try {
            orderTracking = orderTrackingService.getOne(id);
        } catch (NullPointerException exception) {
            logger.error("Controller {} entity with id:{} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
        return orderTracking;
    }

    @Override
    public Set<OrderTracking> getAll() {
            throw new ResponseStatusException(
                    HttpStatus.METHOD_NOT_ALLOWED, "method not allowed");
    }

    @Transactional
    @RequestMapping(value = "/byOrder/{id:.+}", method = RequestMethod.GET)
    public Set<OrderTracking> getAllByOrderId(@PathVariable("id") long id) {
        try {
            return orderTrackingService.getOrderTrackingByOrderId(id);
        } catch (NullPointerException exception) {
            logger.error("Controller {} order tracking information for order id {} not found", this, id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "order information not found", exception);
        }
    }
}
