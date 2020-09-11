package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusService(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Transactional
    public long findByStatusGetId(String status) {
       return orderStatusRepository.findByStatus(status).getId();
    }

    @Transactional
    public OrderStatus getOrderStatusByName(String status) {
        return  orderStatusRepository.findByStatus(status);
    }
}