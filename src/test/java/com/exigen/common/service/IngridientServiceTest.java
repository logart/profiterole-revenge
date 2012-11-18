package com.exigen.common.service;


import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngridientDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class IngridientServiceTest {

    private IngridientServiceImpl ingridientService=new IngridientServiceImpl();


    Recipe recipe=new Recipe();

    @Mock
    IngridientDao ingridientDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getIngridientsService() {
        ingridientService.setIngridientDao(ingridientDao);
        when(ingridientDao.getIngridientsRecipeList(recipe.getRecipeId())).thenReturn(null);
        Assert.assertNull(ingridientService.getIngridientsRecipeList(recipe.getRecipeId()));
    }



}
