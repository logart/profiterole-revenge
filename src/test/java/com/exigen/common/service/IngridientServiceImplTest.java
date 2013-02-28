package com.exigen.common.service;


import com.exigen.common.domain.Ingredient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngridientDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class IngridientServiceImplTest {         //TODO

//    private IngridientServiceImpl ingridientService = new IngridientServiceImpl();
//
//
//    Recipe recipe = new Recipe();
//
//     List<Integer> recipesId=new ArrayList<Integer>();
//
//
//    Ingredient ingredient =new Ingredient("ingr",8,5,"unit",recipe);
//    Ingredient ingredientTwo = new Ingredient("ingr2",7,3,"un",recipe);
//
//    List<Ingredient> ingredients =new ArrayList<Ingredient>();
//
//
//    @Mock
//    IngridientDao ingridientDao;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void getIngridientsServiceTest() {
//        ingridientService.setIngredientDao(ingridientDao);
//        when(ingridientDao.getIngridientsRecipeList(recipe.getRecipeId())).thenReturn(null);
//        Assert.assertNull(ingridientService.getIngridientsRecipeList(recipe.getRecipeId()));
//    }
//
//    @Test
//    public void getAllIngridientsWithOutRecipesInjTest(){
//        ingredients.add(ingredient);
//        ingredients.add(ingredientTwo);
//        ingridientService.setIngredientDao(ingridientDao);
//        when(ingridientDao.getAllIngridients()).thenReturn(ingredients);
//        Assert.assertEquals(ingredients,ingridientDao.getAllIngridients());
//    }
//
//    @Test
//    public void getIngridientByIdTest(){
//        when(ingridientDao.getIngridientById(ingredient.getIngridientId())).thenReturn(ingredient);
//        ingridientService.setIngredientDao(ingridientDao);
//        Assert.assertEquals(ingredient,ingridientDao.getIngridientById(ingredient.getIngridientId()));
//    }
//
//    public void getAllIngridientsTest(){
//     recipesId.add(recipe.getRecipeId());
//        when(ingridientDao.getIngridientsRecipeList(recipesId.get(0))).thenReturn(ingredients);
//        ingridientService.setIngredientDao(ingridientDao);
//        Assert.assertEquals(8,ingridientService.getAllIngridients(recipesId).get(0).getCountOfIngridient());
//
//    }


}