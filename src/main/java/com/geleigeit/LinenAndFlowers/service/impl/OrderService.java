package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.enums.Role;
import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import com.geleigeit.LinenAndFlowers.repository.OrderRepository;
import com.geleigeit.LinenAndFlowers.repository.OrderStatusRepository;
import com.geleigeit.LinenAndFlowers.security.SecurityUser;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

@Service
public class OrderService extends AbstractService<Order, OrderRepository> {

    private final UserService userService;
    private final OrderStatusRepository orderStatusRepository;
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    public OrderService(OrderRepository repository,
                        UserService userService,
                        OrderStatusRepository orderStatusRepository) {
        super(repository);
        this.userService = userService;
        this.orderStatusRepository = orderStatusRepository;
    }

    @Transactional
    public Set<Order> getAllByOrderStatusIdAndDeliveryServiceId(long orderStatusId, long deliveryServiceId) {
        return repository.findAllByOrderStatusIdAndDeliveryServiceId(orderStatusId, deliveryServiceId);
    }

    @Transactional
    public Order getOneByOrderStatusIdAndDeliveryServiceIdAndId(long orderStatus, long deliveryService, long id) {
       return repository.findByOrderStatusIdAndDeliveryServiceIdAndId(orderStatus, deliveryService, id);
    }

    @Transactional
    public Set<Order> getAllOrdersByStatus(long id) {
        return repository.findAllByOrderStatusId(id);
    }

    @Override
    @Transactional
    public void addOne(Order order) {
        repository.save(order);
    }

    @Transactional
    @Scheduled(cron = "0 10 08-23 * * *")
    public void SetStatusToInProgress() {

        long currentOrderStatus = orderStatusRepository.findByStatus("QUEUE").getId();
        OrderStatus orderStatusToSet = orderStatusRepository.findByStatus("IN_PROGRESS");

        //authentication user 'Schedule'
        long scheduleId = 2;
        Authentication auth = new UsernamePasswordAuthenticationToken(SecurityUser.fromUser(
                userService.getUser(scheduleId)), Role.ADMIN);
        SecurityContextHolder.getContext().setAuthentication(auth);

        try {
            Set<Order> orders = repository.findAllByOrderStatusId(currentOrderStatus);
            for(Order order : orders) {
                //convert difference between creation time and current time from milliseconds to days
                int diff = (int) ((new Date().getTime() - order.getCreatedDate().getTime()) / (24 * 60 * 60 * 100));
                if(diff >= 1) {
                    order.setOrderStatus(orderStatusToSet);
                    logger.info("order status QUEUE was changed to IN_PROGRESS by order id({})", order.getId());
                    repository.save(order);
                }
            }
        } catch (NullPointerException e) {
            logger.info("no orders with status QUEUE");
        }
    }
}