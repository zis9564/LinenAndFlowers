package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.repository.OrderRepository;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order, OrderRepository> {

    public OrderService(OrderRepository repository) {
        super(repository);
    }
}
