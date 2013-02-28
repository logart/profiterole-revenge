package com.exigen.common.service;

import com.exigen.common.domain.Category;
import com.exigen.common.repository.CategoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoriesService")

/**
 * Class {@code CategoriesService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public class CategoriesServiceImpl implements CategoriesService {
    /**
     * {@code categoriesDao} describes the CategoriesDao for work with
     * DB and Category entity
     */
    @Autowired
    private CategoriesDao categoriesDao;

    /**
     * {@method getCategory()}
     *
     * @return the list of all category, when it situated in Category entity
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoriesDao.getCategories();
    }

    /**
     * {@method getCategory(Integer id)}
     * @param id(ID of category)
     * @return the categorie with id specified in the passed parameter.
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    @Transactional(readOnly = true)
    public Category getCategory(Integer id) {
        return categoriesDao.getCategory(id);
    }

    /**
     * {@method addCategories(Category categ)}
     * for add info about our category of recipes into DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    @Transactional
    public void addCategories(Category categ) {
        categoriesDao.addCategories(categ);
    }

    /**
     * {@method removeCategories(Category category)}
     * for remove our category of recipes from DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    @Transactional
    public void removeCategories(Category categ) {
        categoriesDao.removeCategories(categ);
    }

    /**
     * {@method setCategoriesDao(CategoriesDao categoriesDao)}
     * for tests services. Inject in this class
     */

    public void setCategoriesDao(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }
}