package com.exigen.common.domain;

import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class CuisineTest {

    @Test
    public void testGetSetId() throws Exception {
        Cuisine    cuisine = new Cuisine();
        assertNull(cuisine.getId());
        Integer test = 2;
        cuisine.setId(test);
        Assert.assertEquals(test, cuisine.getId());
    }

    @Test
    public void testGetSetName() throws Exception {
        Cuisine cuisine = new Cuisine();
        assertNull(cuisine.getName());
        String name = "Cuisine";
        cuisine.setName(name);
        Assert.assertEquals(name, cuisine.getName());
    }

    @Test
    public void testGetSetImage() throws Exception {
        Cuisine cuisine = new Cuisine();
        assertNull(cuisine.getImage());
        String image = "Cuisine";
        cuisine.setName(image);
        Assert.assertEquals(image, cuisine.getImage());
    }

    @Test
    public void testGetSetRecipeList(){
        Cuisine cuisine = new Cuisine();
        List<Recipe> recipeList=new ArrayList<Recipe>();
        Recipe recipe=new Recipe();
        recipeList.add(0,recipe);
        assertNull(cuisine.getRecipeList());
        cuisine.setRecipeList(recipeList);
        Assert.assertEquals(recipeList, cuisine.getRecipeList());
    }
}