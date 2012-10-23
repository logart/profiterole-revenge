package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Meal;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service("recipeService")
@Transactional(readOnly = true)
public class RecipeServiceImpl implements RecipeService {
    /**
     * {@inheritDoc}
     */
    @Autowired
    private RecipeDao recipeDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeList(Meal meal) {
        return recipeDao.getRecipeList(meal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        return recipeDao.getRecipeCuisineList(cuisine);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getOneRecipeList(Integer recipeId) {

        return recipeDao.getOneRecipeList(recipeId);

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void addRecipe(Recipe recipe) {
        recipeDao.addRecipe(recipe);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void removeRecipe(Recipe recipe) {
        recipeDao.removeRecipe(recipe);
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}
