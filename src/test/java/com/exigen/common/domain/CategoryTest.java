package com.exigen.common.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class CategoryTest {
    private Category category;

    @Test
    public void testGetSetCateg() throws Exception {
        category = new Category();

        String testCat = "category";
        assertNull(category.getName());
        category.setName(testCat);
        assertEquals(testCat, category.getName());

    }

    @Test
    public void testGetSetId() throws Exception {
        category = new Category();
        assertNull(category.getId());
        category.getId();
        Integer test = 1;
        category.setId(test);
        assertEquals(test, category.getId());

    }

    @Test
    public void testGetSetRecipeList(){
        category = new Category();
        List<Recipe> recipeList=new ArrayList<Recipe>();
        Recipe recipe=new Recipe();
        recipeList.add(0,recipe);

        assertNull(category.getRecipeList());

        category.setRecipeList(recipeList);
        assertEquals(recipeList, category.getRecipeList());
    }
}