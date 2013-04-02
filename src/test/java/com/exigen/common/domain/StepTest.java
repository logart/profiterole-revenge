package com.exigen.common.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StepTest {             //TODO
    private Step step = new Step();


    @Test
    public void testGetSetDescription() {
        assertNull(step.getDescription());
        step.setDescription("step");
        assertEquals("step", step.getDescription());
    }

    @Test
    public void testGetSetRecipe() {
        Recipe recipe = new Recipe();
        assertNull(step.getRecipe());
        step.setRecipe(recipe);
        assertEquals(recipe, step.getRecipe());
    }

    @Test
    public void testGetSetStepNumber() {
        assertEquals(null, step.getNumber());
        Integer n = 12;
        step.setNumber(n);
        assertEquals(n, step.getNumber());
    }

    @Test
    public void testGetSetImage() {
        assertNull(step.getImage());
        step.setImage("/img/ukr.jpg");
        assertEquals("/img/ukr.jpg", step.getImage());
    }

    @Test
    public void testGetSetId(){
        assertNull(step.getId());
        step.setId(5);
        assertEquals((Object)5,step.getId());
    }

    @Test
    public void testStep(){
        Recipe recipe = new Recipe();
        Step step = new Step("описание","/img/ukr.jpg", 1, recipe);
        assertEquals("описание",step.getDescription());
        assertEquals("/img/ukr.jpg",step.getImage());
        assertEquals((Integer)1,step.getNumber());
        assertEquals(recipe,step.getRecipe());
    }
}