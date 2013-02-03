package com.exigen.common.service;

import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CuisineDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class CuisineServiceImplTest {
    @Mock
    CuisineDao cuisineDao;

    Recipe recipe = new Recipe();

    List<Recipe> recipeList=new ArrayList<Recipe>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCuisine() throws Exception {
        CuisineServiceImpl cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        when(cuisineDao.getCuisine()).thenReturn(null);
        Assert.assertNull(cuisineService.getCuisine());

    }

    @Test
    public void testGetOneCuisine(){
        recipeList.add(recipe);
        CuisineServiceImpl cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        when(cuisineDao.getOneCuisineList(10)).thenReturn(recipeList);
        Assert.assertEquals(recipeList, cuisineService.getOneCuisine(10));
    }
}