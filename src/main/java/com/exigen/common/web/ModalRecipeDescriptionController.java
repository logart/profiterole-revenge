package com.exigen.common.web;

import com.exigen.common.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code ModalRecipeDescriptionController} is used to create
 * modal window with information about chosed recipe
 * @DATE July 25, 2012
 * @author Ivan.
 */

@Controller
public class ModalRecipeDescriptionController {

    /**
     * {@code recipeService} describes the RecipeService for inject on this
     * class
     */

    @Autowired
    private RecipeService recipeService;

    /**
     * {@method modalRecipeDescription()} using for mapped ajax queries      *
     *
     * @return description of some recipe in modal window
     */

    @RequestMapping(value = {"/modalRecipeDescription"})
    @ResponseBody
    public ModelAndView modalRecipeDescription(@RequestParam("recipeId") Integer recipeId) {


        return new ModelAndView("modalRecipeDescription", "model", this.recipeService.getOneRecipe(recipeId));
    }
}
