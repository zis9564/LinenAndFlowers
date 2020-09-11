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
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findAllInDeliverTest() {
        long status = 3; //"IN_DELIVERY"
        long company = 3; //"UPS"

        List<Order> expectedOrderList = new ArrayList<>();
        expectedOrderList.add(orderService.getOne(1));

        List<Order> actualOrderList = orderService.getAllByOrderStatusIdAndDeliveryServiceId(status, company);

        Assert.assertEquals(expectedOrderList.get(0).getId(), actualOrderList.get(0).getId());
    }
}
