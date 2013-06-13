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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.mockito.Mockito.when;


public class SummarizingListControllerTest {

    @Mock
    IngredientBucketService ingredientBucketService;

    @Mock
    HttpServletRequest request;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSummarizingListController() throws Exception {

        IngredientBucket ingredientBucket = new IngredientBucket();
        List<IngredientBucket> ingredients = new LinkedList<IngredientBucket>();
        ingredients.add(ingredientBucket);

        SummarizingListController summarizingListController = new SummarizingListController();

        ReflectionTestUtils.setField(summarizingListController, "ingredientBucketService",
                this.ingredientBucketService);

        ReflectionTestUtils.setField(summarizingListController, "request",
                this.request);

        Map<Integer, Integer> idMap = new HashMap<Integer, Integer>();
        Integer recipeId = 1;
        Integer recipeIdCount = 5;
        idMap.put(recipeId, recipeIdCount);


        when(ingredientBucketService.getAllIngredientBuckets(idMap)).thenReturn(ingredients);

        ModelAndView modelAndView = summarizingListController.summarizingListController(request);

        Assert.assertEquals("summarizingList", modelAndView.getViewName());

    }
}
