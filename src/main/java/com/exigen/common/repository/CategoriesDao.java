package com.exigen.common.repository;

import com.exigen.common.domain.Categories;

import java.util.List;

/**
 * Interface {@code CategoriesDao} used for get, add and remove objects
 * from Categories entity with helps JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public interface CategoriesDao {

    /**
     * {@method getCategories()}
     *
     * @return the list of all categories, when it situated in Categories entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    List<Categories> getCategories();

    /**
     * {@method addCategories(Categories categ)}
     * for add info about our categories of recipes into DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    void addCategories(Categories categ);

    /**
     * {@method removeCategories(Categories categories)}
     * for remove our categories of recipes from DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    void removeCategories(Categories categ);

}