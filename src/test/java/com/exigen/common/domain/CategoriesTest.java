package com.exigen.common.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class CategoriesTest {
    private Categories categories;

    @Test
    public void testGetSetCateg() throws Exception {
        categories = new Categories();

        String testCat = "category";
        assertNull(categories.getCateg());
        categories.setCateg(testCat);
        assertEquals(testCat, categories.getCateg());

    }

    @Test
    public void testGetSetId() throws Exception {
        categories = new Categories();
        assertNull(categories.getCategoriesId());
        categories.getCategoriesId();
        Integer test = 1;
        categories.setCategoriesId(test);
        assertEquals(test, categories.getCategoriesId());

    }

    @Test
    public void testGetSetRecipeList(){
        categories = new Categories();
        List<Recipe> recipeList=new ArrayList<Recipe>();
        Recipe recipe=new Recipe();
        recipeList.add(0,recipe);

        assertNull(categories.getRecipeList());

        categories.setRecipeList(recipeList);
        assertEquals(recipeList,categories.getRecipeList());
    }
}