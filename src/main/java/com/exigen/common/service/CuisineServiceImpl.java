package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CuisineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service("cuisineService")

public class CuisineServiceImpl implements CuisineService {
    /**
     * {@code cuisineDao} describes the CuisineDao work with DB and Cuisine entity
     */
    @Autowired
    private CuisineDao cuisineDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cuisine> getCuisine() {
        return cuisineDao.getCuisine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getOneCuisine(Integer cuis) {
        return cuisineDao.getOneCuisineList(cuis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addCuisine(Cuisine cuisine) {
        cuisineDao.addCuisine(cuisine);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void removeCuisine(Cuisine cuisine) {
        cuisineDao.removeCuisine(cuisine);
    }

    public void setCuisineDao(CuisineDao categoriesDao) {
        this.cuisineDao = categoriesDao;
    }
}
