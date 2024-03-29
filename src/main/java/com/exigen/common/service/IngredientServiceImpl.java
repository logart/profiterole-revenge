package com.exigen.common.service;

import com.exigen.common.domain.Ingredient;
import com.exigen.common.repository.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * {@inheritDoc}
 */

@Service("ingredientService")
@Transactional(readOnly = true)
public class IngredientServiceImpl implements IngredientService {

    /**
     * {@code ingredientDao} describes the IngredientDao work with DB and Ingredient entity
     */
    @Autowired
    private IngredientDao ingredientDao;

    /**
     * {@method getAllIngredientsSortedList()}
     *
     * @return the list of ingredients.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */

    @Override
    public List<String> getIngredientsListByLetter(String term) {
        List<String> result = new ArrayList<String>();
        List<Ingredient> ingredientList = ingredientDao.getIngredientsListByLetter(term);
        int i=0;
        for (Ingredient ingredient : ingredientList){
            result.add(i,ingredient.getName());
            i++;
        }
        return result;
    }

    /**
     * {@method getIngredientIdByName(String ingredientName)}
     *
     * @return the Id of ingredients.
     *
     * @throws EmptyResultDataAccessException)(when search has no results in the database)
     */
    @Override
    public Integer getIngredientIdByName(String ingredientName){
        try {
           Ingredient ingredient = ingredientDao.getIngredientByName(ingredientName) ;
           return ingredient.getId();
        }
        catch (EmptyResultDataAccessException ex){
           return null;
        }
    }


    /**
     * {@method getAllIngredientsSortedList()}
     *
     * @return the list of ingredients.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */

    @Override
    public List<Ingredient> getAllIngredientsSortedList() {
        return ingredientDao.getAllIngredients();

    }
    /**
     * {@method getIngredientById()}
     * @param ingredientId (ID of some ingredient)
     * @return the ingredient with id = ingridientId.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */

    @Override
    public Ingredient getIngredientById(Integer ingredientId) {
        return ingredientDao.getIngredientById(ingredientId);
    }

    /**
     * {@method addIngredient(Ingredient ingredient)}
     * for adding information about some particular ingredient into DB
     *
     * @param ingredient (object of some particular ingredient)
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when ingredient is null)
     */
    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientDao.addIngredient(ingredient);
    }

    /**
     * {@method removeIngredient(Ingredient ingredient)}
     * for remove some particular ingredient from DB
     *
     * @param ingredient (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when ingredient is null)
     */
    @Override
    public void removeIngredient(Ingredient ingredient) {
        ingredientDao.removeIngredient(ingredient);
    }
    /**
     * {@method setIngredientDao(IngredientDao ingredientDao)}
     * set  IngredientDao
     *
     * @param ingredientDao (object of IngredientDao)
     */
    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }


}