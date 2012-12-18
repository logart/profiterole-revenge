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

}