package com.exigen.common.service;

import com.exigen.common.domain.Ingridient;
import com.exigen.common.repository.IngridientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * {@inheritDoc}
 */

@Service("ingridientService")
@Transactional(readOnly = true)
public class IngridientServiceImpl implements IngridientService {

    /**
     * {@code ingridientDao} describes the IngridientDao work with DB and Ingridient entity
     */
    @Autowired
    private IngridientDao ingridientDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ingridient> getIngridientsRecipeList(Integer recipeId) {
        return ingridientDao.getIngridientsRecipeList(recipeId);
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

    public void setIngridientDao(IngridientDao ingridientDao) {
        this.ingridientDao = ingridientDao;
    }

    @Override
    public List<Ingridient> getAllIngridients(List<Integer> listOfRecipesId) {
        List<Ingridient> allIngridientsList = new ArrayList<Ingridient>();
        for (Integer recipeId : listOfRecipesId) {
            allIngridientsList.addAll(getIngridientsRecipeList(recipeId));
        }
        for (int i = 0; i < allIngridientsList.size() - 1; i++) {
            int l = 0;
            for (int j = allIngridientsList.size() - 1; j > i; j--) {
                if (allIngridientsList.get(i).getNameOfIngridient().equalsIgnoreCase(allIngridientsList.get(j).getNameOfIngridient())) {
                    l += allIngridientsList.get(j).getCountOfIngridient();
                    allIngridientsList.remove(j);
                }
            }
            allIngridientsList.get(i).addCountOfIngridient(l);
        }
        return allIngridientsList;
    }
}