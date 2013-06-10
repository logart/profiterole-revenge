package com.exigen.common.service;


import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.RecipeWithMarkers;
import com.exigen.common.repository.RecipeDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService=new RecipeServiceImpl();

    @Mock
    RecipeDao recipeDao;

    Cuisine cuisine=new Cuisine();

    Recipe recipe=new Recipe("title","desc",cuisine,new Category(),"http","smallImg",20,(byte)1);
    Recipe recipeTwo=new Recipe("title2","descr",cuisine,new Category(),"bigImg","smallImg",30,(byte)2);

    List<Recipe> recipes=new ArrayList<Recipe>();

    List<Integer> recipesId=new ArrayList<Integer>();
    Map<String,String> markers = new LinkedHashMap<String, String>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        markers.put("имя","значение");
        ReflectionTestUtils.setField(recipeService,"markers",markers);
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

    @Test
    public void  getMarkersOfRecipeTest(){
        Map<String,String> stringMap =new LinkedHashMap<String, String>();
        stringMap.put("имя","значение");
        Assert.assertEquals(stringMap,recipeService.getMarkersOfRecipe(recipe));
    }

    @Test
    public void getListRecipesWithMarkersTest(){
        recipes.add(recipe);
        RecipeWithMarkers recipeWithMarkers = new RecipeWithMarkers();
        recipeWithMarkers.setRecipe(recipe);
        recipeWithMarkers.setMarkers(markers);
        List<RecipeWithMarkers> resipesWithMarkers = new ArrayList<RecipeWithMarkers>();
        resipesWithMarkers.add(recipeWithMarkers);
        Assert.assertSame(resipesWithMarkers.size(),recipeService.getListRecipesWithMarkers(recipes).size());

    }

    @Test
    public void getListOfMarkersNamesTest(){
        List<String> listMarkersNames = new ArrayList<String>();
        listMarkersNames.add(0,"имя");
        Assert.assertEquals(recipeService.getListOfMarkersNames().get(0),listMarkersNames.get(0));
    }
}
