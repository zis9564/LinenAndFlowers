package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.JpaConfig;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class ColourTest {

    @Autowired
    ColourServiceImpl colourServiceImpl;

    @Test
    public void colourSetTest() {
        Colour colour = new Colour();
        colour.setColour("black");
        colourServiceImpl.addColour(colour);
    }
}
