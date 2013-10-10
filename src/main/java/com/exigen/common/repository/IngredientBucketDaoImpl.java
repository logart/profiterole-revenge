package com.exigen.common.repository;

import com.exigen.common.domain.IngredientBucket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class {@code IngredientBucketDaoImpl} used for get, add and remove objects
 * from IngredientBucket entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */

@Repository("IngredientBucketDao")
public class IngredientBucketDaoImpl implements IngredientBucketDao{

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method getIngredientBucketRecipeList(Integer recipeId)}
     *
     * @param recipeId
     * @return the list of ingredients with count, where Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipeId is null, or has no results in the database)
     */
    @Override
    public List<IngredientBucket> getIngredientBucketRecipeList(Integer recipeId) {
        List<IngredientBucket> results = this.entityManager.createQuery("select ib from IngredientBucket ib WHERE ib" +
                ".recipe.id=:selectedRecipe").setParameter("selectedRecipe", recipeId).getResultList();
        return results;
    }

    /**
     * {@method getIngredientBucketById(Integer ingredientBucketId)}
     *
     * @param ingredientBucketId
     * @return the ingredientBucket by Id
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientBucketId is null, or has no results in the database)
     */
    @Override
    public IngredientBucket getIngredientBucketById(Integer ingredientBucketId) {
        return entityManager.find(IngredientBucket.class, ingredientBucketId);
    }

    /**
     * {@method addIngredientBucket(IngredientBucket ingredientBucket)}
     *  for add some particular ingredient in DB
     * @param ingredientBucket (object of ingredients with count)
     *
     */
    @Override
    public void addIngredientBucket(IngredientBucket ingredientBucket){
        entityManager.persist(ingredientBucket);
    }

    /**
     * {@method removeIngredientBucket(IngredientBucket ingredientBucket);}
     * for remove some particular ingredient from DB
     *
     * @param ingredientBucket (object of some particular recipe)
     *
     */
    @Override
    public void removeIngredientBucket(IngredientBucket ingredientBucket){
        entityManager.remove(ingredientBucket);
    }

    /**
     * {@method getAllIngredientBuckets(List<Integer> listOfRecipesId)}
     * return list of all ingredientBuckets from DB  where Recipe from list
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when listOfRecipesId is null, or has no results in the database)
     */
    @Override
    public List<IngredientBucket> getAllIngredientBuckets(List<Integer> listOfRecipesId){
        List<IngredientBucket> results = this.entityManager.createQuery("select ib from IngredientBucket ib WHERE ib" +
                ".recipe.id IN (:selectedRecipes) order by ib.ingredient.type.name, ib.ingredient.name").setParameter("selectedRecipes", listOfRecipesId).getResultList();
        return results;
    }
}