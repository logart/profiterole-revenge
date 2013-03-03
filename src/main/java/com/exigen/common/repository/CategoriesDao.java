package com.exigen.common.repository;

import com.exigen.common.domain.Category;

import java.util.List;

/**
 * Interface {@code CategoriesDao} used for get, add and remove objects
 * from Category entity with helps JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public interface CategoriesDao {

    /**
     * {@method getCategory()}
     *
     * @return the list of all categories, when it situated in Category entity
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    List<Category> getCategories();
    /**
     * {@method getCategory(Integer id)}
     *
     * @param id(ID of category)
     * @return the categorie with id specified in the passed parameter.
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    Category getCategory(Integer id);
    /**
     * {@method addCategories(Category categ)}
     * for add info about our categories of recipes into DB
     *
     * @param category(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    void addCategories(Category category);

    /**
     * {@method removeCategories(Category categories)}
     * for remove our categories of recipes from DB
     *
     * @param category(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    void removeCategories(Category category);

}