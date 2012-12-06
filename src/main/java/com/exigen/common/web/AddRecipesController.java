package com.exigen.common.web;


import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.service.CategoriesService;
import com.exigen.common.service.CuisineService;
import com.exigen.common.service.IngridientService;
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

    @Autowired

    private CuisineService cuisineService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired

    private IngridientService ingridientService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAddingRecipe(Map model) {
        AddRecipeData data = new AddRecipeData();
        model.put("addRecipeData", data);
        model.put("cuisinesList",this.cuisineService.getCuisine());
        model.put("categories",this.categoriesService.getCategories());
        model.put("ingridients",this.ingridientService.getAllIngridientsWithOutRecipesInj());
        return "addRecipes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingRecipe(Map model, @ModelAttribute("addRecipeData") @Valid AddRecipeData data, BindingResult errors) {
        model.put("addRecipeData", data);
        model.put("cuisinesList",this.cuisineService.getCuisine());
        model.put("categories",this.categoriesService.getCategories());
        model.put("ingridients",this.ingridientService.getAllIngridientsWithOutRecipesInj());
        if (errors.hasErrors()) {
            return "addRecipes";
        }else
            return "redirect:addRecipes";
    }

}
