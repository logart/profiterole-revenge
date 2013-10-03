package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.IngredientBucketDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import junit.framework.Assert;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientBucketServiceImplTest {

    @Mock
    IngredientBucketDao ingredientBucketDao;

    private IngredientBucketServiceImpl ingredientBucketService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllIngredientBucketsTest2(){

        Map<Integer,Integer> numberOfRecipe = new HashMap<Integer, Integer>();
        numberOfRecipe.put(0, 5);
        numberOfRecipe.put(1, 3);

        List<Integer> listOfRecipesId = new ArrayList<Integer>();
        listOfRecipesId.add(0);
        listOfRecipesId.add(1);
        Recipe recipe1 = new Recipe();
        recipe1.setId(0);
        Recipe recipe2 = new Recipe();
        recipe2.setId(1);

        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        IngredientType type_t1 = new IngredientType("молочные продукты + яйца");
        IngredientType type_t2 = new IngredientType("мясные продукты");
        IngredientType type_t3 = new IngredientType("рыбные продукты");
        List<IngredientType> listOfTypes = new ArrayList<IngredientType>(Arrays.asList(type_t1,type_t2,type_t3 ));

        ingredientList.add(0,new Ingredient("сахар", listOfTypes.get(0)));
        ingredientList.get(0).setId(0);

        ingredientList.add(1, new Ingredient("мука",listOfTypes.get(1)));
        ingredientList.get(1).setId(1);

        ingredientList.add(2,new Ingredient("вода",listOfTypes.get(2)));
        ingredientList.get(2).setId(2);

        MeasuresBucket measuresBucket = new MeasuresBucket();
        List<IngredientBucket> ingredientBucketList = new ArrayList<IngredientBucket>();
        int i =0;
        ingredientBucketList.add(new IngredientBucket(ingredientList.get(0), 300,measuresBucket,recipe1));
        ingredientBucketList.get(i).setId(i);
        ++i;
        ingredientBucketList.add(new IngredientBucket(ingredientList.get(2), 200,measuresBucket,recipe1));
        ingredientBucketList.get(i).setId(i);
        ++i;
        ingredientBucketList.add(new IngredientBucket(ingredientList.get(0), 250,measuresBucket,recipe2));
        ingredientBucketList.get(i).setId(i);
        ++i;
        ingredientBucketList.add(new IngredientBucket(ingredientList.get(1), 100,measuresBucket,recipe2));
        ingredientBucketList.get(i).setId(i);
        ++i;
        ingredientBucketList.add( new IngredientBucket(ingredientList.get(2), 50,measuresBucket,recipe2));
        ingredientBucketList.get(i).setId(i);

        ingredientBucketService = new IngredientBucketServiceImpl();
        ReflectionTestUtils.setField(ingredientBucketService, "ingredientBucketDao",
                this.ingredientBucketDao);

        when(ingredientBucketDao.getAllIngredientBuckets(listOfRecipesId)).thenReturn(ingredientBucketList);
        Assert.assertEquals(ingredientBucketService.getAllIngredientBuckets(numberOfRecipe).size(),3);

    }

    @Test
    public void getIngredientBucketByIdTest(){
        IngredientBucket  ingredientBucket =new IngredientBucket();
        Integer ingredientBucketId = 0;

        ingredientBucketService = new IngredientBucketServiceImpl();
        ingredientBucketService.setIngredientBucketDao(ingredientBucketDao);
        when(ingredientBucketDao.getIngredientBucketById(ingredientBucketId)).thenReturn(ingredientBucket);
        Assert.assertEquals(ingredientBucketService.getIngredientBucketById(ingredientBucketId),ingredientBucket);
    }


}
