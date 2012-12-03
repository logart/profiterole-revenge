package com.exigen.common.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class  {@code AddRecipesController} creates for mapped "addRecipes" view
 *
 * @author Ivan.
 * @DATE Dec 03, 2012
 */

@Controller
public class AddRecipesController {

    /**
     * {@method menuPage()} using for mapped view
     *
     * @return view name
     */

    @RequestMapping(value = {"/addRecipes"})
    public String menuPage() {

        return "addRecipes";
    }
}
