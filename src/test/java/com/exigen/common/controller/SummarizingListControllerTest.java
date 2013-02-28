package com.exigen.common.controller;

import com.exigen.common.domain.Ingredient;
import com.exigen.common.service.IngridientService;
import com.exigen.common.web.SummarizingListController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class SummarizingListControllerTest {

    @Mock
    IngridientService ingridientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSummarizingListController() throws Exception {

        List<Integer> idList=new ArrayList<Integer>();
        idList.add(1);

        Ingredient ingredient =new Ingredient();

        List<Ingredient> ingredients =new ArrayList<Ingredient>();

        ingredients.add(ingredient);



        SummarizingListController summarizingListController=new SummarizingListController();

        ReflectionTestUtils.setField(summarizingListController, "ingridientService", this.ingridientService);

        when(ingridientService.getAllIngridients(idList)).thenReturn(ingredients);

        ModelAndView modelAndView=summarizingListController.summarizingListController(idList);

        Assert.assertEquals("summarizingList",modelAndView.getViewName());
        
      }
}
