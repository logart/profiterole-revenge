package com.exigen.common.service;

import com.exigen.common.domain.Ingredient;
import com.exigen.common.repository.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


/**
 * {@inheritDoc}
 */

@Service("ingridientService")
@Transactional(readOnly = true)
public class IngridientServiceImpl implements IngridientService {

    /**
     * {@code ingredientDao} describes the IngredientDao work with DB and Ingredient entity
     */
    @Autowired
    private IngredientDao ingredientDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ingredient> getIngridientsRecipeList(Integer recipeId) {
        return ingredientDao.getIngredientsRecipeList(recipeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ingredient> getAllIngridientsWithOutRecipesInj() {
        List<Ingredient> ingredientsSort;
        ingredientsSort = ingredientDao.getAllIngredients();
        Collections.sort(ingredientsSort);
        return ingredientsSort;
    }

    @Override
    public Ingredient getIngridientById(Integer ingridientId) {
        return ingredientDao.getIngredientById(ingridientId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngridient(Ingredient ingredient) {
        ingredientDao.addIngredient(ingredient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngridient(Ingredient ingredient) {
        ingredientDao.removeIngredient(ingredient);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public List<Ingredient> getAllIngridients(List<Integer> listOfRecipesId) {
//        List<Ingredient> allIngridientsList = new ArrayList<Ingredient>();
//        for (Integer recipeId : listOfRecipesId) {
//            allIngridientsList.addAll(getIngredientsRecipeList(recipeId));
//        }
//        for (int i = 0; i < allIngridientsList.size() - 1; i++) {
//            int l = 0;
//            for (int j = allIngridientsList.size() - 1; j > i; j--) {
//                if (allIngridientsList.get(i).getNameOfIngridient().equalsIgnoreCase(allIngridientsList.get(j).getNameOfIngridient())) {
//                    l += allIngridientsList.get(j).getCountOfIngridient();
//                    allIngridientsList.remove(j);
//                }
//            }
//            allIngridientsList.get(i).addCountOfIngridient(l);
//        }
//        return allIngridientsList; //TODO
        return null;
    }
}