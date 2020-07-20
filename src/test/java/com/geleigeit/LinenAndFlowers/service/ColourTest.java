package com.geleigeit.LinenAndFlowers.service;

import com.geleigeit.LinenAndFlowers.config.DataConfig;
import com.geleigeit.LinenAndFlowers.entity.Colour;
import com.geleigeit.LinenAndFlowers.repository.ColourRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@WebAppConfiguration
public class ColourTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    ColourService colourService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void colourSetTest() {
        Colour colour = new Colour();
        colour.setColour("black");
        colourService.addColour(colour);
    }
}
