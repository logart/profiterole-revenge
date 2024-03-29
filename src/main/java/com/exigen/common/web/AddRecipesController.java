package com.exigen.common.web;

import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

    private static final String DEFAULT_IMAGE_FOR_STEP = "http://img15.imageshack.us/img15/9802/stepav.jpg";
    private static final String DEFAULT_IMAGE_FOR_RECIPE_HEAD = "http://imageshack.us/a/img825/4148/98824036.gif";

    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private AddRecipeDataService addRecipeDataService;
    @Autowired
    private AddRecipeDataValidator addRecipeDataValidator;
    @Autowired
    private ImageService imageService;
    @Autowired
    private RecipeService recipeService;

    private List<Category> categories;
    private List<Cuisine> cuisines;


    private List<String> imagesForSteps = new ArrayList<String>();
    private List<String> markersNames = new ArrayList<String>();


    @RequestMapping(method = RequestMethod.GET)
    public String showAddingRecipe(Map model) {
        AddRecipeData data = new AddRecipeData();
        categories = this.categoriesService.getCategories();
        cuisines = this.cuisineService.getCuisine();
        markersNames = this.recipeService.getListOfMarkersNames();

        model.put("addRecipeData", data);
        model.put("cuisines", cuisines);
        model.put("categories", categories);
        model.put("markersNames",markersNames);
        return "addRecipes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingRecipe(Map model, @ModelAttribute("addRecipeData") @Valid AddRecipeData data, BindingResult errors) throws IOException {

        categories = this.categoriesService.getCategories();
        cuisines = this.cuisineService.getCuisine();


        ValidationUtils.invokeValidator(addRecipeDataValidator, data, errors);

        if (errors.hasErrors()) {
            model.put("addRecipeData", data);
            model.put("cuisines", cuisines);
            model.put("categories", categories);
            model.put("markersNames",markersNames);
            return "addRecipes";
        }
        List<MultipartFile> multipartFiles = data.getFiles();

        for (int i = 0; i < multipartFiles.size(); i++) {
            if (multipartFiles.get(i).isEmpty()) {
                imagesForSteps.add(DEFAULT_IMAGE_FOR_STEP);
            } else {
                imagesForSteps.add(i, imageService.postImage(multipartFiles.get(i).getBytes(), multipartFiles.get(i).getOriginalFilename()));
            }
        }
        data.setImagesForStepsList(imagesForSteps);

        if (data.getImages().isEmpty()) {
            data.setImageForRecipeHead(DEFAULT_IMAGE_FOR_RECIPE_HEAD);
        } else {
            data.setImageForRecipeHead(imageService.postImage(data.getImages().getBytes(), data.getImages().getOriginalFilename()));
        }
        data.setCategory(addRecipeDataService.getCategoryFromListByID(Integer.parseInt(data.getCategoryId()), categories));
        data.setCuisine(addRecipeDataService.getCuisineFromListByID(Integer.parseInt(data.getCuisineId()), cuisines));
        addRecipeDataService.addRecipe(data);
        return "redirect:success";
    }


     @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,List<String>> getIngredientsList(@RequestParam(value = "searchString", required = false) String term) {
        Map<String, List<String>> searchMap = new HashMap<String, List<String>>();
         searchMap.put("searchMap", this.ingredientService.getIngredientsListByLetter(term));
        return searchMap;
    }

    @RequestMapping(value = "/getIngredientId", method = RequestMethod.POST)
    @ResponseBody
    public  Integer getIngredientId(@RequestParam(value = "ingredientName", required = false) String ingredientName) {

        return  this.ingredientService.getIngredientIdByName(ingredientName);

    }

}