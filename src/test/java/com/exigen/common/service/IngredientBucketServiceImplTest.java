package com.exigen.common.service;

import com.exigen.common.domain.Ingredient;
import com.exigen.common.domain.IngredientBucket;
import com.exigen.common.domain.MeasuresBucket;
import com.exigen.common.domain.Recipe;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        ingredientList.add(0,new Ingredient("сахар"));
        ingredientList.get(0).setId(0);

        ingredientList.add(1, new Ingredient("мука"));
        ingredientList.get(1).setId(1);

        ingredientList.add(2,new Ingredient("вода"));
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
