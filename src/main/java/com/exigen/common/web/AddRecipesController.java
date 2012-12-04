package com.exigen.common.web;


import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.service.AddRecipeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Class  {@code AddRecipesController} creates for mapped "addRecipes" view
 *
 * @author Ivan.
 * @DATE Dec 03, 2012
 */

@Controller
@RequestMapping("/addRecipes")
public class AddRecipesController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAddingRecipe(Map model) {
        AddRecipeData data = new AddRecipeData();
        model.put("addRecipeData", data);
        model.put("temp", "");      //TODO
        return "addRecipes";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processAddingRecipe(Map model, @ModelAttribute("addRecipeData") @Valid AddRecipeData data, BindingResult errors) {
        model.put("addRecipeData", data);
        model.put("temp", data.getIngredientList()[0]);//TODO
        if (errors.hasErrors()) {
            return "addRecipes";
        }else
            return "redirect:addRecipes";
    }

}
