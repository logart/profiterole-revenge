package com.exigen.common.controller;

import com.exigen.common.domain.IngredientBucket;
import com.exigen.common.service.IngredientBucketService;
import com.exigen.common.web.SummarizingListController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;


public class SummarizingListControllerTest {

    @Mock
    IngredientBucketService ingredientBucketService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSummarizingListController() throws Exception {

        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);

        IngredientBucket ingredientBucket = new IngredientBucket();

        List<IngredientBucket> ingredients = new LinkedList<IngredientBucket>();

        ingredients.add(ingredientBucket);


        SummarizingListController summarizingListController = new SummarizingListController();

        ReflectionTestUtils.setField(summarizingListController, "ingredientBucketService",
                this.ingredientBucketService);

        when(ingredientBucketService.getAllIngredientBuckets(idList)).thenReturn(ingredients);

        ModelAndView modelAndView = summarizingListController.summarizingListController(idList);

        Assert.assertEquals("summarizingList", modelAndView.getViewName());

    }
}
