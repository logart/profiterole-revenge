package com.exigen.common.service;

import com.exigen.common.domain.Categories;

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
