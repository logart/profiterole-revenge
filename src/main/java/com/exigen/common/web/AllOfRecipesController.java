package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code MenuController} creates cuisines and recepies
 * freemarker pages with information about cuisines and recipes
 * with ajax support
 */
@Controller
public class AllOfRecipesController {

    /**
     * {@method allOfRecipes()} using for load all cuisines to the page
     *
     * @return all cuisines list
     */
    @RequestMapping(value = {"/allOfRecipes"})
    public ModelAndView allOfRecipes() {

        return new ModelAndView("allOfRecipes");
    }
}
