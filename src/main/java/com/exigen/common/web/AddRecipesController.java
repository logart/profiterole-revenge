package com.exigen.common.web;


import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Ingridient;
import com.exigen.common.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
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
    AddRecipeDataValidator validator = new AddRecipeDataValidator();
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private IngridientService ingridientService;
    @Autowired
    private RecipeService recipeService;
    private AddRecipeDataService addRecipeDataService = new AddRecipeDataService();
    private List<Categories> categories;
    private List<Cuisine> cuisines;
    private List<Ingridient> ingridients;

    @RequestMapping(method = RequestMethod.GET)
    public String showAddingRecipe(Map model) {
        AddRecipeData data = new AddRecipeData();
        categories = this.categoriesService.getCategories();
        cuisines = this.cuisineService.getCuisine();
        ingridients = this.ingridientService.getAllIngridientsWithOutRecipesInj();
        model.put("addRecipeData", data);
        model.put("cuisines", cuisines);
        model.put("categories", categories);
        model.put("ingredients", ingridients);
        return "addRecipes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingRecipe(Map model, @ModelAttribute("addRecipeData") @Valid AddRecipeData data, BindingResult errors) {
        if (categories == null || cuisines == null || ingridients == null) {
            categories = this.categoriesService.getCategories();
            cuisines = this.cuisineService.getCuisine();
            ingridients = this.ingridientService.getAllIngridientsWithOutRecipesInj();
        }
        ValidationUtils.invokeValidator(validator, data, errors);
        if (errors.hasErrors()) {
            model.put("addRecipeData", data);
            model.put("cuisines", cuisines);
            model.put("categories", categories);
            model.put("ingredients", ingridients);
            return "addRecipes";
        }
        data.setCategory(addRecipeDataService.getCategoryFromListByID(Integer.parseInt(data.getCategory().getCateg()), categories));
        data.setCuisine(addRecipeDataService.getCuisineFromListByID(Integer.parseInt(data.getCuisine().getCuisin()), cuisines));
        recipeService.addRecipe(data);
        return "redirect:success";
    }

}
