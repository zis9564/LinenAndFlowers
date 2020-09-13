package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.geleigeit.LinenAndFlowers.service.impl.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

//    @Test
//    public void findAllInDeliverTest() {
//        long status = 3; //"IN_DELIVERY"
//        long company = 3; //"UPS"
//
//        Set<Order> expectedOrderList = new HashSet<>();
//        expectedOrderList.add(orderService.getOne(1));
//
//        Set<Order> actualOrderList = orderService.getAllByOrderStatusIdAndDeliveryServiceId(status, company);
//
//        Assert.assertEquals(expectedOrderList.get(0).getId(), actualOrderList.get(0).getId());
//    }
}
