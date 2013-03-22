package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CuisineDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CuisineServiceImplTest {
    @Mock
    CuisineDao cuisineDao;

    CuisineServiceImpl cuisineService;

    Recipe recipe = new Recipe();

    List<Recipe> recipeList=new ArrayList<Recipe>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetCuisine() throws Exception {
        cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        when(cuisineDao.getCuisine()).thenReturn(null);
        Assert.assertNull(cuisineService.getCuisine());

    }

    @Test
    public void testGetOneCuisine(){
        recipeList.add(recipe);
        cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        when(cuisineDao.getOneCuisineRecipesList(10)).thenReturn(recipeList);
        Assert.assertEquals(recipeList, cuisineService.getOneCuisine(10));
    }

    @Test
    public void testAddCuisine(){
        cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        Cuisine cuisine = new Cuisine();
        cuisineDao.addCuisine(cuisine);
        verify(cuisineDao).addCuisine(cuisine);
    }

    @Test
    public void testRemoveCuisine(){
        cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        Cuisine cuisine = new Cuisine();
        cuisineDao.removeCuisine(cuisine);
        verify(cuisineDao).removeCuisine(cuisine);
    }
}