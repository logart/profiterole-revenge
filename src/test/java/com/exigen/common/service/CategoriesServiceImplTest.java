package com.exigen.common.service;

import com.exigen.common.domain.Category;
import com.exigen.common.repository.CategoriesDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class CategoriesServiceImplTest {


    @Mock
    CategoriesDao categoriesDao;

    Category category =new Category();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCategories() throws Exception {
        CategoriesServiceImpl categoriesService = new CategoriesServiceImpl();

        categoriesService.setCategoriesDao(categoriesDao);
        when(categoriesDao.getCategories()).thenReturn(null);
        Assert.assertNull(categoriesService.getCategories());

    }

    @Test
    public void testGetCategory(){
        CategoriesServiceImpl categoriesService = new CategoriesServiceImpl();
        categoriesService.setCategoriesDao(categoriesDao);

        when(categoriesDao.getCategory(23)).thenReturn(category);
        Assert.assertEquals(category,categoriesService.getCategory(23));
    }
}