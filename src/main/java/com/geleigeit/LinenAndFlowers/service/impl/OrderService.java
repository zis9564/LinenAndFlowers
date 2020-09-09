package com.geleigeit.LinenAndFlowers.service.impl;

import com.geleigeit.LinenAndFlowers.entity.enums.Role;
import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderStatus;
import com.geleigeit.LinenAndFlowers.repository.OrderRepository;
import com.geleigeit.LinenAndFlowers.repository.OrderStatusRepository;
import com.geleigeit.LinenAndFlowers.repository.StatusResolvable;
import com.geleigeit.LinenAndFlowers.security.SecurityUser;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService extends AbstractService<Order, OrderRepository> implements StatusResolvable{

    private final OrderStatusRepository orderStatusRepository;
    private final UserService userService;
    private final Logger logger = LogManager.getLogger(OrderService.class);

    public OrderService(OrderRepository repository,
                        OrderStatusRepository orderStatusRepository,
                        UserService userService) {
        super(repository);
        this.orderStatusRepository = orderStatusRepository;
        this.userService = userService;
    }

    @Override
    @Transactional
    @Scheduled(fixedDelay=(60 * 60 * 1000))
    public void toInProgress() {
        long scheduleId = 2;
        String currentStatus = "QUEUE";
        String statusToSet = "IN_PROGRESS";
        OrderStatus currentOrderStatus = orderStatusRepository.findByStatus(currentStatus);
        OrderStatus orderStatusToSet = orderStatusRepository.findByStatus(statusToSet);
        Authentication auth = new UsernamePasswordAuthenticationToken(SecurityUser.fromUser(
                userService.getUser(scheduleId)), Role.ADMIN);
        SecurityContextHolder.getContext().setAuthentication(auth);
        try {
            List<Order> orders = repository.findAllByOrderStatus(currentOrderStatus);
            for(Order order : orders) {
                int diff = (int) ((new Date().getTime() - order.getCreatedDate().getTime()) / (24 * 60 * 60 * 100));
                if(diff >= 1) {
                    order.setOrderStatus(orderStatusToSet);
                    logger.info("order status QUEUE was changed to IN_PROGRESS by order.{}", order.hashCode());
                    repository.save(order);
                }
            }
        } catch (NullPointerException e) {
            logger.info("no orders with status QUEUE");
        }
    }
}