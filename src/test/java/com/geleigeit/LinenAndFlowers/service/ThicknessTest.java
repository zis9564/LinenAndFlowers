package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessServiceImpl;
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
public class ThicknessTest {

    @Autowired
    ThicknessServiceImpl thicknessServiceImpl;

    @Test
    public void AddThicknessTest() {
        Thickness expected = new Thickness();
        expected.setThickness(20);
        Thickness actual = thicknessServiceImpl.addThickness(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void updateThicknessTest() {
        long id = 1;
        Thickness expected = new Thickness();
        expected.setId(id);
        expected.setThickness(10);
        Thickness actual = thicknessServiceImpl.updateThickness(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getOneTest() {
        long id = 1;
        Thickness expected = new Thickness();
        expected.setId(id);
        expected.setThickness(10);
        Thickness actual = thicknessServiceImpl.getOne(id);
        assertEquals(expected, actual);
    }

    @Test
    public void getAllTest() {
        long id = 1;
        Thickness expected = new Thickness();
        expected.setId(id);
        expected.setThickness(10);
        List<Thickness> expectedList = new ArrayList<>();
        expectedList.add(expected);
        List<Thickness> actualList = thicknessServiceImpl.getAll();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void deleteThicknessTest() {
        long id = 1;
        Thickness actual = thicknessServiceImpl.deleteThickness(id);
        assertNotNull(actual.getDeletedAt());
    }
}
