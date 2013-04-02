package com.exigen.common.service;



import com.exigen.common.domain.IngredientBucket;

import java.util.List;
/**
 * Interface {@code IngredientBucketService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Lena
 * @date March 1,2013
 */

public interface IngredientBucketService {
    /**
     * {@method getIngredientBucketRecipeList(Integer recipeId)}
     *
     * @param recipeId
     * @return the list of ingredients with count, where Recipe entity =@param).

     */
    List<IngredientBucket> getIngredientBucketRecipeList(Integer recipeId);
    /**
     * {@method getIngredientBucketById(Integer ingredientBucketId)}
     *
     * @param ingredientBucketId
     * @return the ingredientBucket by Id

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
     *
     * @param listOfRecipesId list of Id
     *
     */

    List<IngredientBucket> getAllIngredientBuckets(List<Integer> listOfRecipesId);
}
