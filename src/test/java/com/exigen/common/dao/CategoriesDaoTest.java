package com.exigen.common.dao;

import com.exigen.common.domain.Category;
import com.exigen.common.repository.CategoriesDao;
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
    private Category testCategory;


    @Before
    public void setup() {
        testCategory = new Category("test");
    }


    @Test
    public void addCategoriesTest() {


        categoriesDao.addCategories(testCategory);
        Assert.assertEquals(testCategory, categoriesDao.getCategories().get(0));
    }


    @Test
    public void getCategoriesTest() {
        Assert.assertNotNull(categoriesDao.getCategories());
    }


    @Test
    public void getCategoryTest(){
        categoriesDao.addCategories(testCategory);
        Assert.assertNotNull(categoriesDao.getCategory(testCategory.getId()));
        categoriesDao.removeCategories(testCategory);
    }
}