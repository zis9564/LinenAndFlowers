package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.OrderTrackingRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class OrderTrackingService extends AbstractService<OrderTracking, OrderTrackingRepository> {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    public OrderTrackingService(OrderTrackingRepository repository) {
        super(repository);
    }

    @Transactional
    public void addOne(OrderTracking orderTracking) {
        repository.save(orderTracking);
        logger.info("new tracking information id {} added", orderTracking.getId());
    }

    @Transactional
    public OrderTracking getOne(long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Set<OrderTracking> getOrderTrackingByOrderId(long id) throws NullPointerException {
            return repository.findAllByOrderId(id);
    }
}
