package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;

import java.util.List;

/**
 * Interface {@code AddRecipeDataServiceImpl} used for add new recipe to DB, and for
 * editing input data
 *
 * @author Oleg Kalinichenko
 * @date December 30,2012
 */
public interface AddRecipeDataService {
    public Categories getCategoryFromListByID(Integer id, List<Categories> list);

    public Cuisine getCuisineFromListByID(Integer id, List<Cuisine> list);

    public void addRecipe(AddRecipeData data);
}
