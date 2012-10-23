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
 */
@Controller
public class RecipeIdController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RecipeIdController.class);
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private RecipeService recipeService;


    /**
     * A method for displaying the Recipe
     */
    @RequestMapping(value = {"/recipe"})
    public ModelAndView recipeIdPage(@RequestParam("cuisineId") Integer cuisineId)

    {

//        LOGGER.error(Charset.defaultCharset().name());
//        for (byte b:s.getBytes("UTF-8")){
//            LOGGER.error("byte "+b);
//        }
//        LOGGER.error("Looking for cuisine "+new String(s.getBytes()));
        return new ModelAndView("recipe", "model", this.cuisineService.getOneCuisine(cuisineId));
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


