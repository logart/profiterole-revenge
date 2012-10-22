package com.exigen.common.service;


import com.exigen.common.domain.Recipe;

import java.util.List;

/**
 */
public interface RecipeIdService {
    List<Recipe> getOneRecipeList(Integer recipeId);
}
