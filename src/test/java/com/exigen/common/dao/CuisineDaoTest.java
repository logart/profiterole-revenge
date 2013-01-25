package com.exigen.common.dao;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CuisineDao;
import com.exigen.common.repository.RecipeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CuisineDaoTest {


    @Autowired
    private CuisineDao cuisineDao;
    @Autowired
    private RecipeDao recipeDao;


    private Cuisine testCuisine;
    private Recipe testRecipe;


    @Before
    public void setup() {
        testCuisine = new Cuisine("test", "test");
    }


    @Test
    public void addCuisineTest() {


        cuisineDao.addCuisine(testCuisine);
        Assert.assertEquals(testCuisine, cuisineDao.getCuisine().get(0));
    }


    @Test
    public void getCategoriesTest() {
        Assert.assertNotNull(cuisineDao.getCuisine());
    }


}