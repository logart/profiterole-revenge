package com.exigen.common.domain;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class IngredientBucketTest {

   @Test
    public void testGetSetId() throws Exception {
       IngredientBucket ingredientBucket = new IngredientBucket();

       assertNull(ingredientBucket.getId());
       Integer test = 2;
       ingredientBucket.setId(test);
       assertEquals(test, ingredientBucket.getId());
    }

   @Test
    public void testGetSetIngredient() throws Exception{
       IngredientBucket ingredientBucket = new IngredientBucket();

       assertNull(ingredientBucket.getIngredient());
       Ingredient ingredient = new Ingredient();
       ingredientBucket.setIngredient(ingredient);
       assertEquals(ingredient,ingredientBucket.getIngredient());
   }

    @Test
    public void testGetSetCountOfIngredient() throws Exception {
        IngredientBucket ingredientBucket = new IngredientBucket();

        assertNull(ingredientBucket.getCountOfIngredient());
        float test = 1;
        ingredientBucket.setCountOfIngredient(test);
        assertEquals(ingredientBucket.getCountOfIngredient(), test, 0.0);
    }

    @Test
    public void testGetSetMeasuresBucket() throws Exception{
        IngredientBucket ingredientBucket = new IngredientBucket();

        assertNull(ingredientBucket.getMeasuresBucket());
        MeasuresBucket measuresBucket =new MeasuresBucket();
        ingredientBucket.setMeasuresBucket(measuresBucket);
        assertEquals(measuresBucket,ingredientBucket.getMeasuresBucket());
    }

    @Test
    public void testGetSetRecipe() throws Exception{
        IngredientBucket ingredientBucket = new IngredientBucket();

        assertNull(ingredientBucket.getRecipe());
        Recipe recipe = new Recipe();
        ingredientBucket.setRecipe(recipe);
        assertEquals(recipe,ingredientBucket.getRecipe());
    }

}
