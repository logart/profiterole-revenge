package com.exigen.common.service;

import com.exigen.common.domain.Category;
import com.exigen.common.repository.CategoriesDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

    @RunWith(MockitoJUnitRunner.class)
    public class CategoriesServiceImplTest {


    @Mock
    private CategoriesDao categoriesDao;

    CategoriesServiceImpl categoriesService;

    Category category = new Category();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCategories() throws Exception {
        categoriesService = new CategoriesServiceImpl();
        categoriesService.setCategoriesDao(categoriesDao);
        List<Category> categ = new ArrayList<Category>();
        when(categoriesDao.getCategories()).thenReturn(categ);
        Assert.assertEquals(categoriesService.getCategories(), categ);
    }

    @Test
    public void testGetCategory(){
        categoriesService = new CategoriesServiceImpl();
        categoriesService.setCategoriesDao(categoriesDao);

        when(categoriesDao.getCategory(23)).thenReturn(category);
        Assert.assertEquals(category,categoriesService.getCategory(23));
    }

    @Test
    public void testAddCategory(){
        categoriesService = new CategoriesServiceImpl();
        categoriesService.setCategoriesDao(categoriesDao);
        Category category1 = new Category("Закуски");
        categoriesDao.addCategories(category1);
        verify(categoriesDao).addCategories(category1);
    }

        @Test
        public void testRemoveCategory(){
            categoriesService = new CategoriesServiceImpl();
            categoriesService.setCategoriesDao(categoriesDao);
            Category category1 = new Category("Закуски");
            category1.setId(1);
            categoriesDao.removeCategories(category1);
            verify(categoriesDao).removeCategories(category1);
        }
}