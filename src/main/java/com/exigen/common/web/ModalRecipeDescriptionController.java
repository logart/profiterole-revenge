package com.exigen.common.web;


import com.exigen.common.service.IngridientService;
import com.exigen.common.service.RecipeService;
import com.exigen.common.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Class  {@code ModalRecipeDescriptionController} is used to create
 * modal window with information about chosed recipe
 *
 * @author Ivan.
 * @DATE July 25, 2012
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
     * {@code ingridientService} describes the IngridientService for inject on this
     * class
     */


    @Autowired
    private IngridientService ingridientService;


    /**
     * {@code stepService} describes the StepService for inject on this
     * class
     */


    @Autowired
    private StepService stepService;




    /**
     * {@method modalRecipeDescription()} using for mapped ajax queries      *
     *
     * @return description of some recipe in modal window
     */


    @RequestMapping(value = {"/modalRecipeDescription"})
    @ResponseBody
    public ModelAndView modalRecipeDescription(@RequestParam("recipeId") Integer recipeId) {


        ModelAndView modal_model = new ModelAndView("modalRecipeDescription", "recipe", this.recipeService.getOneRecipe(recipeId));
        modal_model.addObject("step", this.stepService.getListOfRecipeSteps(recipeId));
        modal_model.addObject("ingridient", this.ingridientService.getIngridientsRecipeList(recipeId));


        return modal_model;
    }
}