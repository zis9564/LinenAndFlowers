package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import com.geleigeit.LinenAndFlowers.exception.NotFoundException;
import com.geleigeit.LinenAndFlowers.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {

    private OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusService(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    public OrderStatus getOne(long id) {
        OrderStatus orderStatus = orderStatusRepository.findById(id).orElseThrow(NotFoundException::new);
        return orderStatus;
    }

    public OrderStatus getOneByStatus(String status) {
       return orderStatusRepository.findByStatus(status);
    }

    public List<OrderStatus> orderStatusList() {
        return (List<OrderStatus>) orderStatusRepository.findAll();
    }
}