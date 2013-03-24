package com.exigen.common.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RecipeTest {
    private Recipe recipe;

    @Before
    public void setRecipe() throws Exception {
        recipe = new Recipe();
    }

    @Test
    public void testSetAndGetTitle() {
        String testTitle = "aTitle";
        assertNull(recipe.getTitle());
        recipe.setTitle(testTitle);
        assertEquals(testTitle, recipe.getTitle());
    }

    @After
    public void testTitle() {
        System.out.println("test of title is done");
    }

    @Test
    public void GetSetRecipeId() {
        Integer test = 2;
        assertNull(recipe.getId());
        recipe.setId(test);
        assertEquals(test, recipe.getId());
    }

    @Test
    public void getSetDescriptionTest(){
        assertNull(recipe.getDescription());
        recipe.setDescription("desc");
        assertEquals("desc",recipe.getDescription());
    }

    @Test
    public void getSetTimeTest(){
        recipe.setTimeOfCooking(6);
        assertEquals(6.0,recipe.getTimeOfCooking(), 0);
    }

    @Test
    public void getSetBigImgTest(){
        assertNull(recipe.getBigImage());
        recipe.setBigImage("bigImg");
        assertEquals("bigImg", recipe.getBigImage());
    }
    
    @Test
    public void getSetSmallImgTest(){
        assertNull(recipe.getSmallImage());
        recipe.setSmallImage("smallImg");
        assertEquals("smallImg", recipe.getSmallImage());
    }

    @Test
    public void getSetCuisineTest(){
        Cuisine cuisine=new Cuisine();
        assertNull(recipe.getCuisine());
        recipe.setCuisine(cuisine);
        assertEquals(cuisine,recipe.getCuisine());
    }
    
    @Test
    public void getSetCategories(){
        Category category =new Category();
        assertNull(recipe.getCategory());
        recipe.setCategory(category);
        assertEquals(category,recipe.getCategory());
    }

    @Test
    public void getSetIngredients(){
        IngredientBucket ingredientBucket = new IngredientBucket();
        List<IngredientBucket> ingredientBucketList = new ArrayList<IngredientBucket>();
        ingredientBucketList.add(ingredientBucket);
        assertEquals(true, recipe.getIngredients().isEmpty());
        recipe.setIngredients(ingredientBucketList);
        assertEquals(ingredientBucketList,recipe.getIngredients());
    }

    @Test
    public void getSetStep(){
        Step step = new Step();
        List<Step> stepList = new ArrayList<Step>();
        stepList.add(0,step);
        assertEquals(true, recipe.getSteps().isEmpty());
        recipe.setSteps(stepList);
        assertEquals(stepList,recipe.getSteps());
    }

    @Test
    public void testGetCalories(){
        List<IngredientBucket> ingredientBucketList = new ArrayList<IngredientBucket>();
        Ingredient ingredient = new Ingredient();
        ingredient.setCalories(100);
        MeasuresBucket measuresBucket = new MeasuresBucket();
        measuresBucket.setGramEquals(1);
        IngredientBucket ingredientBucket1 = new IngredientBucket();
        ingredientBucket1.setCountOfIngredient(100);
        ingredientBucket1.setIngredient(ingredient);
        ingredientBucket1.setMeasuresBucket(measuresBucket);
        ingredientBucketList.add(ingredientBucket1);
        recipe.setIngredients(ingredientBucketList);
        assertEquals(100, recipe.getCalories());
    }
}