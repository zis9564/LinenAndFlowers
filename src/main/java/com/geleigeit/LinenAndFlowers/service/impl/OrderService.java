package com.geleigeit.LinenAndFlowers.service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.geleigeit.LinenAndFlowers.entity.enums.Role;
import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.entity.tables.OrderTracking;
import com.geleigeit.LinenAndFlowers.repository.OrderRepository;
import com.geleigeit.LinenAndFlowers.security.SecurityUser;
import com.geleigeit.LinenAndFlowers.service.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService extends AbstractService<Order, OrderRepository> {

    @Value("${ups.url}")
    private String URL;
    @Value("${ups.accesskey}")
    private String ACCESSKEY;

    private final UserService userService;
    private final Logger logger = LogManager.getLogger(OrderService.class);


    @Autowired
    public OrderService(OrderRepository repository,
                        UserService userService) {
        super(repository);
        this.userService = userService;
    }

    @Transactional
    public List<Order> getAllByOrderStatusIdAndDeliveryServiceId(long orderStatusId, long deliveryServiceId) {
        return repository.findAllByOrderStatusIdAndDeliveryServiceId(orderStatusId, deliveryServiceId);
    }

//    @Transactional
//    @Scheduled(fixedDelay=(60 * 60 * 1000))
//    public void toInProgress() {
//
//        long scheduleId = 2;
//        String currentStatus = "QUEUE";
//        String statusToSet = "IN_PROGRESS";
//        long currentOrderStatus = orderStatusRepository.findByStatus(currentStatus).getId();
//        OrderStatus orderStatusToSet = orderStatusRepository.findByStatus(statusToSet);
//
//        //authentication user 'Schedule'
//        Authentication auth = new UsernamePasswordAuthenticationToken(SecurityUser.fromUser(
//                userService.getUser(scheduleId)), Role.ADMIN);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        try {
//            List<Order> orders = repository.findAllByOrderStatus(currentOrderStatus);
//            for(Order order : orders) {
//                //convert difference between creation time and current time from milliseconds to days
//                int diff = (int) ((new Date().getTime() - order.getCreatedDate().getTime()) / (24 * 60 * 60 * 100));
//                if(diff >= 1) {
//                    order.setOrderStatus(orderStatusToSet);
//                    logger.info("order status QUEUE was changed to IN_PROGRESS by order id({})", order.getId());
//                    repository.save(order);
//                }
//            }
//        } catch (NullPointerException e) {
//            logger.info("no orders with status QUEUE");
//        }
//    }
}