package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.service.impl.FabricService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FabricTest {

    private static final long id = 1;

    @Autowired
    FabricService fabricService;

}