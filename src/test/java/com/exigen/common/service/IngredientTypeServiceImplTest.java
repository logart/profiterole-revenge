package com.exigen.common.service;

import com.exigen.common.domain.IngredientType;
import com.exigen.common.repository.IngredientTypeDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IngredientTypeServiceImplTest {

    @Mock
    IngredientTypeDao ingredientTypeDao;

    private IngredientTypeServiceImpl ingredientTypeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  getIngredientByIdTest() {
        ingredientTypeService = new IngredientTypeServiceImpl();
        ingredientTypeService.setIngredientTypeDao(ingredientTypeDao);
        IngredientType type = new IngredientType();
        type.setId(1);
        when(ingredientTypeDao.getIngredientTypeById(1)).thenReturn(type);
        Assert.assertEquals(ingredientTypeService.getIngredientTypeById(1), type);
    }

    @Test
    public void  addIngredientTest() {
        ingredientTypeService = new IngredientTypeServiceImpl();
        ingredientTypeService.setIngredientTypeDao(ingredientTypeDao);
        IngredientType type = new IngredientType();
        ingredientTypeDao.addIngredientType(type);
        verify(ingredientTypeDao).addIngredientType(type);

    }

    @Test
    public void  removeIngredientTest() {
        ingredientTypeService = new IngredientTypeServiceImpl();
        ingredientTypeService.setIngredientTypeDao(ingredientTypeDao);
        IngredientType type = new IngredientType();
        ingredientTypeDao.removeIngredientType(type);
        verify(ingredientTypeDao).removeIngredientType(type);

    }
}
