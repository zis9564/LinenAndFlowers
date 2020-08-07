package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.service.impl.FabricServiceImpl;
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
public class FabricTest {

    private static final long id = 1;

    @Autowired
    FabricServiceImpl fabricService;

    public FabricTest() {
    }

    private static Colour createColour(){
        Colour colour = new Colour();
        colour.setColour("yellow");
        colour.setId(id);
        return colour;
    }
    private static Type createType() {
        Type type = new Type();
        type.setId(id);
        type.setType("silk");
        return type;
    }
    private static Thickness createThickness() {
        Thickness thickness = new Thickness();
        thickness.setId(id);
        thickness.setThickness(10);
        return thickness;
    }

//    @Test
//    public void addFabricTest() {
//        Fabric expectedFabric = new Fabric();
//        expectedFabric.setId(id);
//        expectedFabric.setLength(10);
//        expectedFabric.setColour(createColour());
//        expectedFabric.setType(createType());
//        expectedFabric.setThickness(createThickness());
//        Fabric actualFabric = fabricService.addFabric(expectedFabric);
//        assertEquals(expectedFabric, actualFabric);
//    }
//
//    @Test
//    public void updateFabricTest() {
//        Fabric expectedFabric = new Fabric();
//        expectedFabric.setId(id);
//        expectedFabric.setLength(5);
//        expectedFabric.setColour(createColour());
//        expectedFabric.setType(createType());
//        expectedFabric.setThickness(createThickness());
//        Fabric actualFabric = fabricService.updateFabric(expectedFabric);
//        assertEquals(expectedFabric, actualFabric);
//    }
//
//    @Test
//    public void getOneTest() {
//        Fabric expectedFabric = new Fabric();
//        expectedFabric.setId(id);
//        expectedFabric.setLength(5);
//        expectedFabric.setColour(createColour());
//        expectedFabric.setType(createType());
//        expectedFabric.setThickness(createThickness());
//        Fabric actualFabric = fabricService.getOne(id);
//        assertEquals(expectedFabric, actualFabric);
//    }
//
//    @Test
//    public void getAllTest() {
//        Fabric expectedFabric = new Fabric();
//        expectedFabric.setId(id);
//        expectedFabric.setLength(5);
//        expectedFabric.setColour(createColour());
//        expectedFabric.setType(createType());
//        expectedFabric.setThickness(createThickness());
//        List<Fabric> expectedList = new ArrayList<>();
//        expectedList.add(expectedFabric);
//        List<Fabric> actualList = fabricService.getAllFabrics();
//        assertEquals(expectedList, actualList);
//    }
//
//    @Test
//    public void deleteFabricTest() {
//        Fabric actual = fabricService.deleteFabric(id);
//        assertNotNull(actual.getDeletedAt());
//    }
}