package com.exigen.common.service;


import com.exigen.common.domain.Category;
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

public class RecipeServiceImplTest {        //TODO

    RecipeServiceImpl recipeService=new RecipeServiceImpl();

    @Mock
    RecipeDao recipeDao;

    Cuisine cuisine=new Cuisine();

    Recipe recipe=new Recipe("title","desc",cuisine,new Category(),"http","smallImg",20);
    Recipe recipeTwo=new Recipe("title2","descr",cuisine,new Category(),"bigImg","smallImg",30);

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
         when(recipeDao.getOneRecipe(recipes.get(0).getId())).thenReturn(recipes.get(0));
         recipeService.setRecipeDao(recipeDao);
         Assert.assertEquals(recipe,recipeService.getOneRecipe(recipes.get(0).getId()));
     }
}
