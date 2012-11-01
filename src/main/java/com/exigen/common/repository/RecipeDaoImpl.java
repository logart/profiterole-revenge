package com.exigen.common.repository;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("recipeDao")
public class RecipeDaoImpl implements RecipeDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Recipe> getOneRecipeList(Integer recipeId) {
        List<Recipe> results1 = this.entityManager.createNamedQuery("Recipe.findRecipeById")
                .setParameter("selectedId", recipeId).getResultList();
        return results1;
    }

    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine(object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null, or id has no results in the database)
     */
    @Override
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        List<Recipe> results = this.entityManager.createNamedQuery("Recipe.findRecipeFromCuisine")
                .setParameter("selectedCuisine", cuisine)
                .getResultList();


        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRecipe(Recipe recipe) {
        entityManager.persist(recipe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeRecipe(Recipe recipe) {
        entityManager.remove(recipe);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
