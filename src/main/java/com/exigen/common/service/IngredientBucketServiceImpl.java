package com.exigen.common.service;

import com.exigen.common.domain.IngredientBucket;
import com.exigen.common.repository.IngredientBucketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class {@code IngredientBucketServiceImpl} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Elena
 * @date March 4,2013
 */
@Service("ingredientBucketService")
@Transactional(readOnly = true)
public class IngredientBucketServiceImpl implements IngredientBucketService {
    /**
     * {@code ingredientBucketDao} describes the IngredientBucketDao for work with
     * DB and MeasureBucket entity
     */
    @Autowired
    private IngredientBucketDao ingredientBucketDao;

    /**
     * {@method getIngredientBucketRecipeList(Integer recipeId)}
     * list of the object of IngredientBucket for recipe with Id = @param
     *
     * @param recipeId Id of recipe
     * @return the object  of List<IngredientBucket>
     * @throws org.springframework.dao.DataAccessException
     *          (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<IngredientBucket> getIngredientBucketRecipeList(Integer recipeId) {
        return ingredientBucketDao.getIngredientBucketRecipeList(recipeId);
    }

    /**
     * {@method getIngredientBucketById(Integer ingredientBucketId)}
     *
     * @param ingredientBucketId
     * @return the ingredientBucket by Id
     * @throws org.springframework.dao.DataAccessException
     *          (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public IngredientBucket getIngredientBucketById(Integer ingredientBucketId) {
        return ingredientBucketDao.getIngredientBucketById(ingredientBucketId);
    }

    /**
     * {@method addIngredientBucket(IngredientBucket ingredientBucket)}
     * for add some particular ingredient in DB
     *
     * @param ingredientBucket (object of ingredients with count)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measuresBucket is null)
     */

    @Override
    public void addIngredientBucket(IngredientBucket ingredientBucket) {
        ingredientBucketDao.addIngredientBucket(ingredientBucket);
    }

    /**
     * {@method removeIngredientBucket(IngredientBucket ingredientBucket);}
     * for remove some particular ingredient from DB
     *
     * @param ingredientBucket (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measuresBucket is null)
     */
    @Override
    public void removeIngredientBucket(IngredientBucket ingredientBucket) {
        ingredientBucketDao.removeIngredientBucket(ingredientBucket);
    }

    /**
     * {@method getAllIngredientBuckets(List<Integer> listOfRecipesId)}
     * return list of all ingredientBuckets from DB  where Recipe from list
     *
     * @param listOfRecipesId list of Id
     * @throws org.springframework.dao.DataAccessException
     *          (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */

    public List<IngredientBucket> getAllIngredientBuckets(List<Integer> listOfRecipesId) {
        return ingredientBucketDao.getAllIngredientBuckets(listOfRecipesId);
    }

    /**
     * {@method setIngredientBucketDao(IngredientBucketDao ingredientBucketDao)}
     * set  IngredientBucketDao
     *
     * @param ingredientBucketDao (object of ingredientBucketDao)
     */
    public void setIngredientBucketDao(IngredientBucketDao ingredientBucketDao) {
        this.ingredientBucketDao = ingredientBucketDao;
    }

}
