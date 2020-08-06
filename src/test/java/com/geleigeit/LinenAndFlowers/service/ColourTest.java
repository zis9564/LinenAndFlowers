package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.service.impl.ColourServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColourTest {

    @Autowired
    ColourServiceImpl colourServiceImpl;

    @Test
    public void AddColourTest() {
        Colour expected = new Colour();
        expected.setColour("blue");
//        Colour actual = colourServiceImpl.addColour(expected);
//        assertEquals(expected, actual);
    }

    @Test
    public void updateColourTest() {
        long id = 1;
        Colour expected = new Colour();
        expected.setColour("yellow");
        expected.setId(id);
        Colour actual = colourServiceImpl.updateColour(expected);
        assertEquals (expected, actual);
    }

    @Test
    public void getOneTest() {
        long id = 1;
        Colour expected = new Colour();
        expected.setColour("yellow");
        expected.setId(id);
        Colour actual = colourServiceImpl.getOne(id);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllTest() {
        long id = 1;
        Colour expected = new Colour();
        expected.setColour("yellow");
        expected.setId(id);
        List<Colour> expectedList = new ArrayList<>();
        expectedList.add(expected);
        List<Colour> actualList = colourServiceImpl.getAll();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void deleteColourTest() {
        long id = 1;
        Colour actual = colourServiceImpl.deleteColour(id);
        assertNotNull(actual.getDeletedAt());
    }
}