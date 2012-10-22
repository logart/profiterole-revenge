package com.exigen.common.service;

import com.exigen.common.domain.Categories;
import com.exigen.common.repository.CategoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoriesService")


/**
 * {@inheritDoc}
 */
public class CategoriesServiceImpl implements CategoriesService {
    /**
     * {@code categoriesDao} describes the CategoriesDao for work with
     * DB and Categories entity
     */
    @Autowired
    private CategoriesDao categoriesDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Categories> getCategories() {
        return categoriesDao.getCategories();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void addCategories(Categories categ) {
        categoriesDao.addCategories(categ);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void removeCategories(Categories categ) {
        categoriesDao.removeCategories(categ);
    }

    public void setCategoriesDao(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }
}
