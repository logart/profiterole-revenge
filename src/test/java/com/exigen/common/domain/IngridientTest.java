package com.exigen.common.domain;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class IngridientTest {

    Ingridient ingridient = new Ingridient();

    @Test
    public void testGetSetNameOfIngridient() {
        assertNull(ingridient.getNameOfIngridient());
        ingridient.setNameOfIngridient("ingridient");
        assertEquals("ingridient", ingridient.getNameOfIngridient());
    }

    @Test
    public void testGetSetCalories() {
        assertEquals(ingridient.getCalories(), 0.0, 0.0);
        ingridient.setCalories(5);
        assertEquals(ingridient.getCalories(), 5, 5);
    }

    @Test
    public void testGetSetRecipe() {
        Recipe recipe = new Recipe();
        assertNull(ingridient.getRecipe());
        ingridient.setRecipe(recipe);
        assertEquals(ingridient.getRecipe(), recipe);

    }

    @Test
    public void testGetSetCountOfIngridient() {
        assertEquals(0, ingridient.getCountOfIngridient());
        ingridient.setCountOfIngridient(10);
        assertEquals(10, ingridient.getCountOfIngridient());
    }

    @Test
    public void testGetSetUnitOfMeasure(){
     assertNull(ingridient.getUnitOfMeasure());
        ingridient.setUnitOfMeasure("unit");
        assertEquals("unit",ingridient.getUnitOfMeasure());
    }
}