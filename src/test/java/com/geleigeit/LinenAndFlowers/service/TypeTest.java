package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.service.impl.TypeServiceImpl;
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
public class TypeTest {

    @Autowired
    TypeServiceImpl typeServiceImpl;

//    @Test
//    public void AddTypeTest() {
//        long id = 1;
//        Type expected = new Type();
//        expected.setId(id);
//        expected.setType("cotton");
//        Type actual = typeServiceImpl.addType(expected);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void updateTypeTest() {
//        long id = 1;
//        Type expected = new Type();
//        expected.setId(id);
//        expected.setType("silk");
//        Type actual = typeServiceImpl.updateType(expected);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getOneTest() {
//        long id = 1;
//        Type expected = new Type();
//        expected.setId(id);
//        expected.setType("silk");
//        Type actual = typeServiceImpl.getOne(id);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getAllTest() {
//        long id = 1;
//        Type expected = new Type();
//        expected.setId(id);
//        expected.setType("silk");
//        List<Type> expectedList = new ArrayList<>();
//        expectedList.add(expected);
//        List<Type> actualList = typeServiceImpl.getAll();
//        assertEquals(expectedList, actualList);
//    }
//
//    @Test
//    public void deleteTypeTest() {
//        long id = 1;
//        Type actual = typeServiceImpl.deleteType(id);
//        assertNotNull(actual.getDeletedAt());
//    }
}
