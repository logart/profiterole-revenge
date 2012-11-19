package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class {@code RecipeService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
@Service("recipeService")
@Transactional(readOnly = true)
public class RecipeServiceImpl implements RecipeService {

    private Integer counterOfCalories = 0;

    /**
     * {@code recipeDao} describes the RecipeDao work with DB and Recipe entity
     */
    @Autowired
    private RecipeDao recipeDao;

    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine (object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null, or id has no results in the database)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        return recipeDao.getRecipeCuisineList(cuisine);
    }

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param recipeId (unique identificator of some particular recipe)
     * @return the recipe, where Recipe field recipeId equals parameter recipeId( return complete description
     *         of the recipe with the steps, ingredients, Pictures.).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipeId is null, or id has no results in the database)
     */

    @Override
    @Transactional(readOnly = true)
    public Recipe getOneRecipe(Integer recipeId) {

        return recipeDao.getOneRecipe(recipeId);

    }

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    @Transactional
    public void addRecipe(Recipe recipe) {
        recipeDao.addRecipe(recipe);
    }

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */

    @Transactional
    public void removeRecipe(Recipe recipe) {
        recipeDao.removeRecipe(recipe);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public Integer CaloriesCalculation(List<Integer> recipesId) {
        for (int i = 0; i < recipesId.size(); i++) {
            counterOfCalories = +(recipeDao.getOneRecipe(recipesId.get(i))).getCalories();
        }
        return counterOfCalories;
    }

    /**
     * {@method setRecipeDao(RecipeDao recipeDao)}
     * for tests services. Inject in this class
     */

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}