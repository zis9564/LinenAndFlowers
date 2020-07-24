package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.JpaConfig;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.service.impl.ColourServiceImpl;
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
    public void AddColourTest() {
        Colour colour = new Colour();
        String name = "blue";
        colour.setColour(name);
        colourServiceImpl.addColour(colour);
    }

    @Test
    public void deleteColourTest() {
        long id = 1;
        colourServiceImpl.deleteColour(id);
    }

    @Test
    public void updateColourTest() {
        String name = "black";
        long id = 1;
        colourServiceImpl.updateColour(name, id);
    }

    @Test
    public void getOneTest() {
        long id = 1;
        Colour colour = colourServiceImpl.getOne(id);
        System.out.println(colour.toString());
    }

    @Test
    public void getAllTest() {

    }
}