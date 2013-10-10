package com.exigen.common.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class RecipeWithMarkersTest {
    private RecipeWithMarkers recipeWithMarkers;

    @Before
    public void setRecipeWithMarkers() throws Exception {
        recipeWithMarkers = new RecipeWithMarkers();
    }

    @Test
    public void testSetRecipe() {
        Recipe recipe = new Recipe();
        assertNull(recipeWithMarkers.getRecipe());
        recipeWithMarkers.setRecipe(recipe);
        assertEquals(recipe, recipeWithMarkers.getRecipe());
    }

    @Test
    public void testSetMarkers() {
        Map<String,String> markers = new LinkedHashMap<String, String>();
        assertNull(recipeWithMarkers.getMarkers());
        recipeWithMarkers.setMarkers(markers);
        assertEquals(markers, recipeWithMarkers.getMarkers());
    }
}
