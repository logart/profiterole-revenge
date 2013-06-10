package com.exigen.common.service;


import com.exigen.common.domain.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddRecipeDataServiceImplTest {

    AddRecipeDataServiceImpl addRecipeDataService = new AddRecipeDataServiceImpl();

    Category category = new Category();
    Integer id = category.getId();

    List<Category> categoryList = new ArrayList<Category>();

    Cuisine cuisine = new Cuisine();

    List<Cuisine> cuisineList = new ArrayList<Cuisine>();

    Recipe recipe = new Recipe();

    Ingredient ingredient = new Ingredient("name", 4);

    List<String> steps = new ArrayList<String>();

    @Mock
    IngredientService ingredientService;
    @Mock
    IngredientBucketService ingredientBucketService;
    @Mock
    StepService stepService;
    @Mock
    RecipeService recipeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getCategoryFromListByIDTest() {
        categoryList.add(0, category);
        Assert.assertEquals(category, addRecipeDataService.getCategoryFromListByID(id, categoryList));
    }

    @Test
    public void getCuisineFromListByIDTest() {
        id = cuisine.getId();
        cuisineList.add(cuisine);
        Assert.assertEquals(cuisine, addRecipeDataService.getCuisineFromListByID(id, cuisineList));
    }


      @Test
    public void makeMarkersTest(){
          ReflectionTestUtils.setField(addRecipeDataService, "recipeService", recipeService);
          List<String> markersNames = new ArrayList<String>();
          markersNames.add(0,"aa");
          markersNames.add(1,"bb");
          markersNames.add(2,"cc");
          byte marker = 7;
          AddRecipeData data = new AddRecipeData();
          data.setMarkersNames(markersNames);
          data.setCookingTimeMinutes("9");
          data.setCookingTimeHours("1");
          ArgumentCaptor<Recipe> argument = ArgumentCaptor.forClass(Recipe.class);
          addRecipeDataService.addRecipe(data);
          verify(recipeService).addRecipe(argument.capture());
          Assert.assertEquals((byte)argument.getValue().getMarkers(),marker);
      }
}
