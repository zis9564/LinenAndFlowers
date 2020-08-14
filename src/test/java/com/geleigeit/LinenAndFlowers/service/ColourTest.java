package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.service.impl.ColourService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColourTest {

    @Autowired
    ColourService colourServiceImpl;

}