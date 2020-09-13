package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.OrderTrackingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderTrackingService {

    private final OrderTrackingRepository orderTrackingRepository;
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    public OrderTrackingService(OrderTrackingRepository orderTrackingRepository) {
        this.orderTrackingRepository = orderTrackingRepository;
    }

    @Transactional
    public void addOne(OrderTracking orderTracking) {
        orderTrackingRepository.save(orderTracking);
        logger.info("new tracking information id {} added", orderTracking.getId());
    }

    @Transactional
    public OrderTracking update(OrderTracking newOrderTracking) {
        logger.info("tracking information id {} updated", newOrderTracking.getId());
        return orderTrackingRepository.save(newOrderTracking);
    }

    @Transactional
    public OrderTracking getOne(long id) {
        return orderTrackingRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
