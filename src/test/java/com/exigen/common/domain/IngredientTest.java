package com.exigen.common.domain;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient();

    @Test
    public void testGetSetId() throws Exception {
        assertNull(ingredient.getId());
        Integer test = 2;
        ingredient.setId(test);
        assertEquals(test, ingredient.getId());

    }
    @Test
    public void testGetSetName() throws Exception {
        assertNull(ingredient.getName());
        ingredient.setName("ingredient");
        assertEquals("ingredient", ingredient.getName());
    }

    @Test
    public void testGetSetCalories() throws Exception {
        assertEquals(ingredient.getCalories(), 0.0, 0.0);
        ingredient.setCalories(5);
        assertEquals(ingredient.getCalories(), 5, 5);
    }

    @Test
    public void testGetSetMeasuresBucketList() throws Exception {
        Ingredient ingredient = new Ingredient();
        assertEquals(true,ingredient.getMeasuresBucketList().isEmpty());

        List<MeasuresBucket> measuresBucketList = new ArrayList<MeasuresBucket>();
        MeasuresBucket measuresBucket = new MeasuresBucket();
        measuresBucketList.add(0,measuresBucket);
        ingredient.setMeasuresBucketList(measuresBucketList);
        assertEquals(measuresBucketList,ingredient.getMeasuresBucketList());
    }

}