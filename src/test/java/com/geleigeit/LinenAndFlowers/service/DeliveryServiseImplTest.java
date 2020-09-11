package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.service.impl.DeliveryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeliveryServiseImplTest {

    @Autowired
    DeliveryServiceImpl service;

    @Test
    public void findByNameGetIdTest() {
        long expectedValue = 3;
        long actualValue;
        String findDelivery = "UPS";
        actualValue = service.findByNameGetId(findDelivery);
        Assert.assertEquals(expectedValue, actualValue);
    }
}
