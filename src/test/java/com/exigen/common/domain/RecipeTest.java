package com.exigen.common.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertNull(recipe.getRecipeId());
        recipe.setRecipeId(test);
        assertEquals(test, recipe.getRecipeId());
    }

    @Test
    public void getSetDescriptionTest(){
        assertNull(recipe.getDescription());
        recipe.setDescription("desc");
        assertEquals("desc",recipe.getDescription());
    }

    @Test
    public void getSetCaloriesTest(){
        assertNull(recipe.getCalories());
        recipe.setCalories(6);
        assertEquals((Object) 6, recipe.getCalories());
    }

    @Test
    public void getSetTimeTest(){
        recipe.setTime(6);
        assertEquals(6.0,recipe.getTime(), 0);
    }

    @Test
    public void getSetBigImgTest(){
        assertNull(recipe.getBigImg());
        recipe.setBigImg("bigImg");
        assertEquals("bigImg", recipe.getBigImg());
    }
    
    @Test
    public void getSetSmallImgTest(){
        assertNull(recipe.getSmallImg());
        recipe.setSmallImg("smallImg");
        assertEquals("smallImg", recipe.getSmallImg());
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
        Categories categories=new Categories();
        assertNull(recipe.getCategories());
        recipe.setCategories(categories);
        assertEquals(categories,recipe.getCategories());
    }
}