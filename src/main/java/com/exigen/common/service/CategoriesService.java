package com.exigen.common.service;

import com.exigen.common.domain.Category;

import java.util.List;

/**
 * Interface {@code CategoriesService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */

public interface CategoriesService {

    /**
     * {@method getCategory()}
     *
     * @return the list of all category, when it situated in Category entity
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    List<Category> getCategories();

    /**
     * {@method getCategory(Integer id)}
     * @param id(ID of category)
     * @return the categorie with id specified in the passed parameter.
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    Category getCategory(Integer id);
    /**
     * {@method addCategories(Category categ)}
     * for add info about our category of recipes into DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    void addCategories(Category categ);

    /**
     * {@method removeCategories(Category category)}
     * for remove our category of recipes from DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    void removeCategories(Category categ);
}