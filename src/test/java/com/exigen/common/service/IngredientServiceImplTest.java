package com.exigen.common.service;


import com.exigen.common.domain.Ingredient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngredientDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IngredientServiceImplTest {


    @Mock
    IngredientDao ingredientDao;


    private IngredientServiceImpl ingredientService ;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void  getAllIngredientsSortedListTest() {
        List<Ingredient> ingredients =new ArrayList<Ingredient>();
        Ingredient ingredient11 = new Ingredient("сахар",500);
        Ingredient ingredient12 = new Ingredient("гречка",100);
        ingredients.add(ingredient11);
        ingredients.add(ingredient12);
        when(ingredientDao.getAllIngredients()).thenReturn(ingredients);
        ingredientService = new IngredientServiceImpl();
        ingredientService.setIngredientDao(ingredientDao);
        Assert.assertEquals(ingredientService.getAllIngredientsSortedList(),ingredients );
    }

    @Test
    public void  getIngredientByIdTest() {
        ingredientService = new IngredientServiceImpl();
        ingredientService.setIngredientDao(ingredientDao);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        when(ingredientDao.getIngredientById(1)).thenReturn(ingredient);
        Assert.assertEquals(ingredientService.getIngredientById(1),ingredient );
    }

    @Test
    public void  addIngredientTest() {
        ingredientService = new IngredientServiceImpl();
        ingredientService.setIngredientDao(ingredientDao);
        Ingredient ingredient = new Ingredient();
        ingredientDao.addIngredient(ingredient);
        verify(ingredientDao).addIngredient(ingredient);

    }

    @Test
    public void  removeIngredientTest() {
        ingredientService = new IngredientServiceImpl();
        ingredientService.setIngredientDao(ingredientDao);
        Ingredient ingredient = new Ingredient();
        ingredientDao.removeIngredient(ingredient);
        verify(ingredientDao).removeIngredient(ingredient);

    }

}