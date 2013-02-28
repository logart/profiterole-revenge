package com.exigen.common.web;

import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Ingredient;
import com.exigen.common.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private IngridientService ingridientService;
    @Autowired
    private AddRecipeDataService addRecipeDataService;
    private List<Category> categories;
    private List<Cuisine> cuisines;
    private List<Ingredient> ingredients;

    private List<String> imagesForSteps = new ArrayList<String>();

     private ImageServiceImpl imageService = new ImageServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public String showAddingRecipe(Map model) {
        AddRecipeData data = new AddRecipeData();
        categories = this.categoriesService.getCategories();
        cuisines = this.cuisineService.getCuisine();
        ingredients = this.ingridientService.getAllIngridientsWithOutRecipesInj();
        model.put("addRecipeData", data);
        model.put("cuisines", cuisines);
        model.put("categories", categories);
        model.put("ingredients", ingredients);
        return "addRecipes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingRecipe(Map model, @ModelAttribute("addRecipeData") @Valid AddRecipeData data, BindingResult errors) throws IOException {
        if (categories == null || cuisines == null || ingredients == null) {
            categories = this.categoriesService.getCategories();
            cuisines = this.cuisineService.getCuisine();
            ingredients = this.ingridientService.getAllIngridientsWithOutRecipesInj();
        }


        ValidationUtils.invokeValidator(new AddRecipeDataValidator(), data, errors);
        if (errors.hasErrors()) {
            model.put("addRecipeData", data);
            model.put("cuisines", cuisines);
            model.put("categories", categories);
            model.put("ingredients", ingredients);
            return "addRecipes";
        }


        List<MultipartFile> multipartFiles = data.getFiles();

        for (int i = 0; i < multipartFiles.size(); i++) {
            if (multipartFiles.get(i).isEmpty()) {
                imagesForSteps.add("http://img15.imageshack.us/img15/9802/stepav.jpg");
            } else {
                File saveFile = new File(multipartFiles.get(i).getOriginalFilename());
                saveFile.createNewFile();
                FileOutputStream saveBytes = new FileOutputStream(saveFile);
                saveBytes.write(multipartFiles.get(i).getBytes());
                saveBytes.close();
                imagesForSteps.add(i, imageService.postImage(saveFile));
            }
        }

        data.setImagesForStepsList(imagesForSteps);


        if (data.getImages().isEmpty()) {
            data.setImageForRecipeHead("http://imageshack.us/a/img825/4148/98824036.gif");
        } else {

            File file = new File(data.getImages().getOriginalFilename());

            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);


            fos.write(data.getImages().getBytes());
            fos.close();
            data.setImageForRecipeHead(imageService.postImage(file));
        }

        data.setCategory(addRecipeDataService.getCategoryFromListByID(Integer.parseInt(data.getCategoryId()), categories));
        data.setCuisine(addRecipeDataService.getCuisineFromListByID(Integer.parseInt(data.getCuisineId()), cuisines));
        addRecipeDataService.addRecipe(data);
        return "redirect:success";
    }

}
