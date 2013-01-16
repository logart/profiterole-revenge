package com.exigen.common.web;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.service.CuisineService;
import com.exigen.common.service.RecipeService;
import com.exigen.common.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 08.12.12
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class testCentroller {
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private RecipeService recipeService;
    @RequestMapping(value = {"/test"})
    public ModelAndView fillDb() {
        List<Recipe> list = new ArrayList<Recipe>();
        for (Cuisine c: cuisineService.getCuisine()){
           for (Recipe r: recipeService.getRecipeCuisineList(c)){
               list.add(r);
           }
        }
            return new ModelAndView("test", "model", list);
    }
}
