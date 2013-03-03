package com.exigen.common.repository;

import com.exigen.common.domain.IngredientBucket;

import java.util.List;

/**
 * Interface {@code IngredientBucketDao} used for get, add and remove objects
 * from IngredientBucket entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */
public interface IngredientBucketDao {

    /**
     * {@method getIngredientBucketRecipeList(Integer recipeId)}
     *
     * @param recipeId
     * @return the list of ingredients with count, where Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipeId is null, or has no results in the database)
     */
    List<IngredientBucket> getIngredientBucketRecipeList(Integer recipeId);

    /**
     * {@method getIngredientBucketById(Integer ingredientBucketId)}
     *
     * @param ingredientBucketId
     * @return the ingredientBucket by Id
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientBucketId is null, or has no results in the database)
     */
    IngredientBucket getIngredientBucketById(Integer ingredientBucketId);

    /**
     * {@method addIngredientBucket(IngredientBucket ingredientBucket)}
     *  for add some particular ingredient in DB
     * @param ingredientBucket (object of ingredients with count)
     *
     */
    void addIngredientBucket(IngredientBucket ingredientBucket);

    /**
     * {@method removeIngredientBucket(IngredientBucket ingredientBucket);}
     * for remove some particular ingredient from DB
     *
     * @param ingredientBucket (object of some particular recipe)
     *
     */
    void removeIngredientBucket(IngredientBucket ingredientBucket);

    /**
     * {@method getAllIngredientBuckets(List<Integer> listOfRecipesId)}
     * return list of all ingredientBuckets from DB  where Recipe from list
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when listOfRecipesId is null, or has no results in the database)
     */
    List<IngredientBucket> getAllIngredientBuckets(List<Integer> listOfRecipesId);
}
