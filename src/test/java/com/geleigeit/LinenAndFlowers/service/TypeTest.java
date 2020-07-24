package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.JpaConfig;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.service.impl.TypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TypeTest {

    @Autowired
    TypeServiceImpl typeServiceImpl;

    @Test
    public void AddTypeTest() {
        Type type = new Type();
        String name = "cotton";
        type.setType(name);
        typeServiceImpl.addType(type);
    }

    @Test
    public void deleteTypeTest() {
        long id = 1;
        typeServiceImpl.deleteType(id);
    }

    @Test
    public void updateTypeTest() {
        String name = "silk";
        long id = 1;
        typeServiceImpl.updateType(name, id);
    }

    @Test
    public void getOneTest() {
        long id = 1;
        Type type = typeServiceImpl.getOne(id);
        System.out.println(type.toString());
    }

    @Test
    public void getAllTest() {
        System.out.println(typeServiceImpl.getAll().toString());
    }
}
