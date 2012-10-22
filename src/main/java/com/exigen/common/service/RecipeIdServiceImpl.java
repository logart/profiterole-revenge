package com.exigen.common.service;

import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  {@method List<Recipe> getRecipeList(Integer recipeId)} returns the  recipes where the
 * paramert =recipeId
 */
@Service("recipeIdService")
@Transactional(readOnly = true)
public class RecipeIdServiceImpl implements RecipeIdService {

    @Autowired
    private RecipeDao recipeDao;

    @Override

    public List<Recipe> getOneRecipeList( Integer recipeId ) {

        return   recipeDao.getOneRecipeList(recipeId);

    }
}
