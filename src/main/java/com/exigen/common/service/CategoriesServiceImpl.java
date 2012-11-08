package com.exigen.common.service;

import com.exigen.common.domain.Categories;
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
     * DB and Categories entity
     */
    @Autowired
    private CategoriesDao categoriesDao;

    /**
     * {@method getCategories()}
     *
     * @return the list of all categories, when it situated in Categories entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Categories> getCategories() {
        return categoriesDao.getCategories();
    }

    /**
     * {@method addCategories(Categories categ)}
     * for add info about our categories of recipes into DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    @Transactional
    public void addCategories(Categories categ) {
        categoriesDao.addCategories(categ);
    }

    /**
     * {@method removeCategories(Categories categories)}
     * for remove our categories of recipes from DB
     *
     *
     * @param categoriesId@throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    @Transactional
    public void removeCategories(Integer categoriesId) {
        categoriesDao.removeCategories(categoriesId);
    }

    /**
     * {@method setCategoriesDao(CategoriesDao categoriesDao)}
     * for tests services. Inject in this class
     */

    public void setCategoriesDao(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }
}
