package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.OrderTrackingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderTrackingService {

    private final OrderTrackingRepository orderTrackingRepository;
    private final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    public OrderTrackingService(OrderTrackingRepository orderTrackingRepository) {
        this.orderTrackingRepository = orderTrackingRepository;
    }

    @Transactional
    public void addOne(OrderTracking orderTracking) {
        orderTrackingRepository.save(orderTracking);
    }

    @Transactional
    public void delete(long id) {
        orderTrackingRepository.deleteById(id);
    }

    @Transactional
    public OrderTracking update(OrderTracking newOrderTracking) {
        return orderTrackingRepository.save(newOrderTracking);
    }

    @Transactional
    public OrderTracking getOne(long id) {
        return orderTrackingRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<OrderTracking> getAllByTrackingCode(String trackingCode) {
        return orderTrackingRepository.findAllByTrackingCode(trackingCode);
    }
}
