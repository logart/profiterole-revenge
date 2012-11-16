package com.exigen.common.service;


import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;


import java.util.List;

/**
 * Interface {@code CuisineService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public interface CuisineService {

    /**
     * {@method getCuisine()}
     *
     * @return the list of all cuisines, when it situated in Cuisine entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    List<Cuisine> getCuisine();

    /**
     * {@method getOneCuisineList(Cuisine cuis)}
     *
     * @return the list of recipes, when it situated in this Cuisine.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuis is null, or parameter cuis is does not match
     *                                   no one object in database)
     */
    List<Recipe> getOneCuisine(Integer cuis);

    /**
     * {@method addCuisine(Cuisine cuisine)}
     * for add info about our cuisines into DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    void addCuisine(Cuisine cuisine);

    /**
     * {@method removeCuisine(Cuisine cuisine)}
     * for remove our cuisines from DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    void removeCuisine(Cuisine cuisine);
}