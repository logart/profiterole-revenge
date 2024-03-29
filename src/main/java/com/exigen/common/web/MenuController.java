package com.exigen.common.web;

import com.exigen.common.service.CuisineService;
import com.exigen.common.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code MenuController} creates cuisines and recepies
 * freemarker pages with information about cuisines and recipes
 * with ajax support
 *
 * @author Ivan.
 * @DATE July 25, 2012
 */

@Controller
public class MenuController {

    /**
     * {@code cuisineService} describes the CuisineService for inject on this
     * class
     */

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private RecipeService recipeService;


    /**
     * {@method menuCuisineAjax()} using for mapped ajax queries      *
     *
     * @return list of cuisines
     */

    @RequestMapping(value = {"/menuCuisinesAjax"})
    public ModelAndView menuCuisineAjax() {

        return new ModelAndView("cuisines", "model", this.cuisineService.getCuisine());
    }


    @RequestMapping(value = {"/cuisinesAjax"})
    public ModelAndView cuisinesAjax() {

        return new ModelAndView("cuisinesAjax", "modl", this.cuisineService.getCuisine());
    }

    /**
     * {@method listRecipesToAjax()} using for mapped ajax queries      *
     *
     * @return list of recipes in some cuisine
     */

    @RequestMapping(value = {"/recipeListFromAjax"})
    @ResponseBody
    public ModelAndView listRecipesToAjax(@RequestParam("cuisineId") Integer cuisineId) {
        ModelAndView mav = new ModelAndView("recipeListFromAjax", "model",
                this.recipeService.getListRecipesWithMarkersAndPortion(this.cuisineService.getOneCuisine(cuisineId)));
        mav.addObject("cuisineTitle", this.cuisineService.getCuisine().get(cuisineId - 1).getName());
        return mav;
    }

    @RequestMapping(value = {"/recipes"})
    public ModelAndView listRecipes(@RequestParam("cuisineId") Integer cuisineId) {
        ModelAndView mav = new ModelAndView("recipes", "modl", this.cuisineService.getOneCuisine(cuisineId));
        mav.addObject("cuisineTitle", this.cuisineService.getCuisine().get(cuisineId - 1).getName());
        return mav;
    }

}