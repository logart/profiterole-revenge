package com.exigen.common.service;

import com.exigen.common.domain.Ingridient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngridientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * {@inheritDoc}
 */

@Service("ingridientService")
@Transactional(readOnly = true)
public class IngridientServiceImpl implements IngridientService {

    /**
     * {@code recipeDao} describes the RecipeDao work with DB and Recipe entity
     */
    @Autowired
    private IngridientDao ingridientDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ingridient> getIngridientsRecipeList(Recipe recipe) {
        return ingridientDao.getIngridientsRecipeList(recipe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngridient(Ingridient ingridient) {
        ingridientDao.addIngridient(ingridient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngridient(Ingridient ingridient) {
        ingridientDao.removeIngridient(ingridient);
    }
}