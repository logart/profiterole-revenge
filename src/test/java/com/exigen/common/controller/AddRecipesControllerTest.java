package com.exigen.common.controller;

import com.exigen.common.service.CategoriesService;
import com.exigen.common.service.CuisineService;
import com.exigen.common.service.IngridientService;
import com.exigen.common.web.AddRecipesController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.TreeMap;

import static org.mockito.Mockito.when;


public class AddRecipesControllerTest {
    @Mock
    private CuisineService cuisineService;

    @Mock
    private CategoriesService categoriesService;

    @Mock
    private IngridientService ingridientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testShowAddingRecipe() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingridientService.getAllIngridientsWithOutRecipesInj()).thenReturn(null);

        AddRecipesController addRecipesController=new AddRecipesController();
        ReflectionTestUtils.setField(addRecipesController,"ingridientService", this.ingridientService);
        ReflectionTestUtils.setField(addRecipesController,"cuisineService",this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        String test=addRecipesController.showAddingRecipe(new TreeMap());
        Assert.assertEquals("addRecipes", test);
    }
}
