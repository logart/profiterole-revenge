package com.exigen.common.service;


import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.RecipeDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService=new RecipeServiceImpl();

    @Mock
    RecipeDao recipeDao;

    Cuisine cuisine=new Cuisine();

    Recipe recipe=new Recipe("title","desc",cuisine,new Categories(),"http","smallImg",12,20);
    Recipe recipeTwo=new Recipe("title2","descr",cuisine,new Categories(),"bigImg","smallImg",5,4);

    List<Recipe> recipes=new ArrayList<Recipe>();
    
    List<Integer> recipesId=new ArrayList<Integer>();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRecipeCuisineListTest(){
     recipes.add(recipe);
     recipes.add(recipeTwo);
     when(recipeDao.getRecipeCuisineList(cuisine)).thenReturn(recipes);
        recipeService.setRecipeDao(recipeDao);
        Assert.assertEquals(recipes,recipeDao.getRecipeCuisineList(cuisine));
    }
    
     @Test
    public void getOneRecipeTest(){
         recipes.add(recipe);
         when(recipeDao.getOneRecipe(recipes.get(0).getRecipeId())).thenReturn(recipes.get(0));
         recipeService.setRecipeDao(recipeDao);
         Assert.assertEquals(recipe,recipeService.getOneRecipe(recipes.get(0).getRecipeId()));
     }

    @Test
    public void caloriesCalculationTest(){
        recipesId.add(recipe.getRecipeId());
        recipesId.add(recipeTwo.getRecipeId());
        when(recipeDao.getOneRecipe(recipesId.get(0))).thenReturn(recipe);
        recipeService.setRecipeDao(recipeDao);
        Integer test=recipeService.caloriesCalculation(recipesId);
        when(recipeDao.getOneRecipe(recipesId.get(0))).thenReturn(recipeTwo);
        recipeService.setRecipeDao(recipeDao);
        Integer testTwo=recipeService.caloriesCalculation(recipesId);
        Assert.assertEquals(24,test+testTwo);
        

    }
}
