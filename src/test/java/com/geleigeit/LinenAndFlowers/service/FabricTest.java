package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.entity.Fabric;
import com.geleigeit.LinenAndFlowers.entity.Thickness;
import com.geleigeit.LinenAndFlowers.entity.Type;
import com.geleigeit.LinenAndFlowers.service.impl.FabricServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FabricTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private FabricServiceImpl fabricService;

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @Test
    public void addFabricTest() {
        long id = 1;

        Fabric fabric = new Fabric();
        Colour colour = new Colour();
        Type type = new Type();
        Thickness thickness = new Thickness();

        colour.setId(id);
        type.setId(id);
        thickness.setId(id);

        fabric.setColour(colour);
        fabric.setType(type);
        fabric.setThickness(thickness);

        fabricService.addFabric(fabric);
    }

}