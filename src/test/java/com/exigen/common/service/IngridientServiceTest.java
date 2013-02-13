package com.exigen.common.service;


import com.exigen.common.domain.Ingridient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngridientDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class IngridientServiceTest {

    private IngridientServiceImpl ingridientService = new IngridientServiceImpl();


    Recipe recipe = new Recipe();

     List<Integer> recipesId=new ArrayList<Integer>();


    Ingridient ingridient=new Ingridient("ingr",8,5,"unit",recipe);
    Ingridient ingridientTwo = new Ingridient("ingr2",7,3,"un",recipe);
        
    List<Ingridient> ingridients=new ArrayList<Ingridient>();
    
    
    @Mock
    IngridientDao ingridientDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getIngridientsServiceTest() {
        ingridientService.setIngredientDao(ingridientDao);
        when(ingridientDao.getIngridientsRecipeList(recipe.getRecipeId())).thenReturn(null);
        Assert.assertNull(ingridientService.getIngridientsRecipeList(recipe.getRecipeId()));
    }

    @Test
    public void getAllIngridientsWithOutRecipesInjTest(){
        ingridients.add(ingridient);
        ingridients.add(ingridientTwo);
        ingridientService.setIngredientDao(ingridientDao);
        when(ingridientDao.getAllIngridients()).thenReturn(ingridients);
        Assert.assertEquals(ingridients,ingridientDao.getAllIngridients());
    }

    @Test
    public void getIngridientByIdTest(){
        when(ingridientDao.getIngridientById(ingridient.getIngridientId())).thenReturn(ingridient);
        ingridientService.setIngredientDao(ingridientDao);
        Assert.assertEquals(ingridient,ingridientDao.getIngridientById(ingridient.getIngridientId()));
    }

    public void getAllIngridientsTest(){
     recipesId.add(recipe.getRecipeId());
        when(ingridientDao.getIngridientsRecipeList(recipesId.get(0))).thenReturn(ingridients);
        ingridientService.setIngredientDao(ingridientDao);
        Assert.assertEquals(8,ingridientService.getAllIngridients(recipesId).get(0).getCountOfIngridient());

    }


}