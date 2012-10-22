package com.exigen.common.controller;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.service.CuisineService;
import com.exigen.common.web.MenuController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class MenuControllerServiceTest {
    @Mock
    CuisineService cuisineService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMenuPage(){

        List <Cuisine> cuisines = new ArrayList<Cuisine>();
        cuisines.add(new Cuisine("french","/img/ukr.jpg"));
        when(cuisineService.getCuisine()).thenReturn(cuisines);

        MenuController controller=new MenuController();

        ReflectionTestUtils.setField(controller,"cuisineService",cuisineService);

        ModelAndView mav=controller.menuCuisineAjax();

        assertEquals(cuisines,mav.getModel().get("model"));
        assertEquals("cuisines",mav.getViewName());
    }
}
