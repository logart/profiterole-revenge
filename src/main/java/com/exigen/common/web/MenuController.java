package com.exigen.common.web;

import com.exigen.common.service.CuisineService;
import com.exigen.common.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class for Menu view
 *
 * @author Olga Seredinskaya
 */


@Controller
public class MenuController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private RecipeService recipeService;

    /**
     * A method for displaying the Menu view with twelve categories
     */
    @RequestMapping(value = {"/menu"})
    public String menuPage() {

        return "Menu";
    }

    @RequestMapping(value = {"/menuCuisinesAjax"})
    public ModelAndView menuCuisineAjax() {

        return new ModelAndView("cuisines", "model", this.cuisineService.getCuisine());
    }


    @RequestMapping(value = {"/recipeListFromAjax"})
    public
    @ResponseBody
    ModelAndView listRecipesToAjax(@RequestParam("cuisineId") Integer cuisineId) {

        return new ModelAndView("recipeListFromAjax", "model", this.cuisineService.getOneCuisine(cuisineId));
    }

    @RequestMapping(value = {"/modalRecipeDescription"})
    public
    @ResponseBody
    ModelAndView modalRecipeDescription(@RequestParam("recipeId") Integer recipeId) {


        return new ModelAndView("modalRecipeDescription", "model", this.recipeService.getOneRecipeList(recipeId));
    }
}