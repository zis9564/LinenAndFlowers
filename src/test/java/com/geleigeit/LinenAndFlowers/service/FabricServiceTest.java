package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.DataConfig;
import com.geleigeit.LinenAndFlowers.entity.util.ColourUtil;
import com.geleigeit.LinenAndFlowers.entity.util.ThicknessUtil;
import com.geleigeit.LinenAndFlowers.entity.util.TypeUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class FabricServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private FabricServiceImpl fabricServiceImpl;

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @Test
    public void testAddFabric() {
        final String colourName = "black";
        final String typeName = "silk";
        final int thick = 200;
        fabricServiceImpl.addFabric(colourName, typeName, thick);
    }

    @Test
    public void testDeleteFabric() {
        final long id = 2;
        fabricServiceImpl.deleteFabric(id);
    }

    @Test
    public void testGetFabric() {
        final long id = 1;
        System.out.println(fabricServiceImpl.getFabric(id));
    }

    @Test
    public void testGetAll() {
        fabricServiceImpl.getAll();
    }
}