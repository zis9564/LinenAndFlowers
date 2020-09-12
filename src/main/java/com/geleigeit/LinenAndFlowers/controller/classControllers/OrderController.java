package com.geleigeit.LinenAndFlowers.controller.classControllers;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import com.geleigeit.LinenAndFlowers.service.impl.OrderStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderStatusService orderStatusService;
    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    protected OrderController(OrderService orderService, OrderStatusService orderStatusService) {
        this.orderService = orderService;
        this.orderStatusService = orderStatusService;
    }

    @Transactional
    @RequestMapping(value = "/all/{status:.+}", method = RequestMethod.GET)
    protected List<Order> getAll(@PathVariable("status") long status) {
        long queue = orderStatusService.getOrderStatusByName("QUEUE").getId();
        long inProgress = orderStatusService.getOrderStatusByName("IN_PROGRESS").getId();
        long inDelivery = orderStatusService.getOrderStatusByName("IN_DELIVERY").getId();
        long delivered = orderStatusService.getOrderStatusByName("DELIVERED").getId();
        long canceled = orderStatusService.getOrderStatusByName("CANCELED").getId();

        if(status == queue) {
            return orderService.getAllOrdersByStatus(queue);
        }
        else if (status == inProgress) {
            return orderService.getAllOrdersByStatus(inProgress);
        }
        else if (status == inDelivery) {
            return orderService.getAllOrdersByStatus(inDelivery);
        }
        else if (status == delivered) {
            return orderService.getAllOrdersByStatus(delivered);
        }
        else if (status == canceled) {
            return orderService.getAllOrdersByStatus(canceled);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no objects with this status were found");
    }

    @Transactional
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    protected Order getOne(@PathVariable("id") long id) {
        final Order e;
        try {
            e = orderService.getOne(id);
        } catch (NotFoundException exception) {
            logger.error("Order id:{} not found", id);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found", exception);
        }
        return e;
    }

    @Transactional
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    protected void remove(@PathVariable("id") long id) {
        try {
            orderService.delete(id);
        } catch (IllegalArgumentException exception) {
            logger.error("Order id:{} not found", id);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Entity with given id doesn't exist", exception);
        }
    }

    @Transactional
    @PostMapping
    protected void post(Order order) {
        orderService.addOne(order);
    }

    @Transactional
    @PutMapping
    protected Order put(Order order) {
        try {
            return orderService.update(order);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "some of fields doesn't match", exception);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "given entity is null", exception);
        }
    }
}