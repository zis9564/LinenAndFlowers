package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.JpaConfig;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.service.impl.ThicknessServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class ThicknessTest {

    @Autowired
    ThicknessServiceImpl thicknessService;

    @Test
    public void AddThicknessTest() {
        Thickness thickness = new Thickness();
        int thick = 100;
        thickness.setThickness(thick);
        thicknessService.addThickness(thickness);
    }

    @Test
    public void deleteThicknessTest() {
        long id = 1;
        thicknessService.deleteThickness(id);
    }

    @Test
    public void updateThicknessTest() {
        int thick = 200;
        long id = 1;
        thicknessService.updateThickness(thick, id);
    }

    @Test
    public void getOneTest() {
        long id = 1;
        Thickness thickness = thicknessService.getOne(id);
        System.out.println(thickness.toString());
    }

    @Test
    public void getAllTest() {
        System.out.println(thicknessService.getAll().toString());
    }
}
