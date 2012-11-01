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
 * Controller class for Menu view
 */


@Controller
public class MenuController {

    /**
     * {@code cuisineService} describes the CuisineService for inject on this
     * class
     */

    @Autowired
    private CuisineService cuisineService;

    /**
     * {@code recipeService} describes the RecipeService for inject on this
     * class
     */

    @Autowired
    private RecipeService recipeService;

    /**
     * {@method index()} using for mapped "Menu" page view
     *
     * @return empty view name "Menu"
     */
    @RequestMapping(value = {"/menu"})
    public String menuPage() {

        return "Menu";
    }

    /**
     * {@method menuCuisineAjax()} using for mapped ajax queries      *
     *
     * @return list of cuisines
     */

    @RequestMapping(value = {"/menuCuisinesAjax"})
    public ModelAndView menuCuisineAjax() {

        return new ModelAndView("cuisines", "model", this.cuisineService.getCuisine());
    }

    /**
     * {@method listRecipesToAjax()} using for mapped ajax queries      *
     *
     * @return list of recipes in some cuisine
     */

    @RequestMapping(value = {"/recipeListFromAjax"})
    @ResponseBody
    public ModelAndView listRecipesToAjax(@RequestParam("cuisineId") Integer cuisineId) {

        return new ModelAndView("recipeListFromAjax", "model", this.cuisineService.getOneCuisine(cuisineId));
    }

    /**
     * {@method modalRecipeDescription()} using for mapped ajax queries      *
     *
     * @return description of some recipe in modal window
     */

    @RequestMapping(value = {"/modalRecipeDescription"})
    @ResponseBody
    public ModelAndView modalRecipeDescription(@RequestParam("recipeId") Integer recipeId) {


        return new ModelAndView("modalRecipeDescription", "model", this.recipeService.getOneRecipeList(recipeId));
    }
}