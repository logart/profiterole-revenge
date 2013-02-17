package com.exigen.common.service;


import com.exigen.common.domain.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class AddRecipeDataServiceImplTest {

    AddRecipeDataServiceImpl addRecipeDataService = new AddRecipeDataServiceImpl();

    Categories category = new Categories();
    Integer id = category.getCategoriesId();

    List<Categories> categoriesList = new ArrayList<Categories>();

    Cuisine cuisine = new Cuisine();

    List<Cuisine> cuisineList = new ArrayList<Cuisine>();

    Recipe recipe = new Recipe();

    Ingridient ingridient = new Ingridient("name", 4, 6, "unit", recipe);

    List<String> steps = new ArrayList<String>();

    @Mock
    IngridientService ingridientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getCategoryFromListByIDTest() {
        categoriesList.add(0, category);
        Assert.assertEquals(category, addRecipeDataService.getCategoryFromListByID(id, categoriesList));
    }

    @Test
    public void getCuisineFromListByIDTest() {
        id = cuisine.getCuisineId();
        cuisineList.add(cuisine);
        Assert.assertEquals(cuisine, addRecipeDataService.getCuisineFromListByID(id, cuisineList));
    }

    @Test
    public void getCaloriesTest() {
        List<String> idList = new ArrayList<String>();
        idList.add(0, "1");
        when(ingridientService.getIngridientById(Integer.parseInt(idList.get(0)))).thenReturn(ingridient);
        addRecipeDataService.setIngridientService(ingridientService);
        Assert.assertEquals(ingridient.getCalories(), addRecipeDataService.getCalories(idList));

    }

    @Test
    public void makeStepsTest() {
        Recipe recipe1 = new Recipe();
        steps.add("step");
        List<String> images=new ArrayList<String>();
        images.add("ghf");
        AddRecipeData addRecipeData1 = new AddRecipeData();
        addRecipeData1.setStepsList(steps);
        addRecipeData1.setImageForRecipeHead("");
        addRecipeData1.setImagesForStepsList(images);

        Assert.assertNotNull(addRecipeDataService.makeSteps(addRecipeData1, recipe));
    }
}
