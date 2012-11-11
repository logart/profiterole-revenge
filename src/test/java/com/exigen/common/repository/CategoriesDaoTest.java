package com.exigen.common.repository;

import com.exigen.common.domain.Categories;
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
public class CategoriesDaoTest {


    @Autowired
    private CategoriesDao categoriesDao;
    private Categories testCategories;


    @Before
    public void setup(){
        testCategories=new Categories("test");
    }




    @Test
    public void addCategoriesTest(){


        categoriesDao.addCategories(testCategories);
        Assert.assertEquals(testCategories,categoriesDao.getCategories().get(0));
    }


    @Test
    public void getCategoriesTest(){
        Assert.assertNotNull(categoriesDao.getCategories());
    }


}