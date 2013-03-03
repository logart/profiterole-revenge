package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CuisineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class {@code CuisineService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
@Service("cuisineService")

public class CuisineServiceImpl implements CuisineService {
    /**
     * {@code cuisineDao} describes the CuisineDao work with DB and Cuisine entity
     */
    @Autowired
    private CuisineDao cuisineDao;

    /**
     * {@method getCuisine()}
     *
     * @return the list of all cuisines, when it situated in Cuisine entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cuisine> getCuisine() {
        return cuisineDao.getCuisine();
    }

    /**
     * {@method getOneCuisineRecipesList(Cuisine cuis)}
     *
     * @return the list of recipes, when it situated in this Cuisine.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuis is null, or parameter cuis is does not match
     *                                   no one object in database)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getOneCuisine(Integer cuis) {
        return cuisineDao.getOneCuisineRecipesList(cuis);
    }

    /**
     * {@method addCuisine(Cuisine cuisine)}
     * for add info about our cuisines into DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    @Override
    @Transactional
    public void addCuisine(Cuisine cuisine) {
        cuisineDao.addCuisine(cuisine);
    }

    /**
     * {@method removeCuisine(Cuisine cuisine)}
     * for remove our cuisines from DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    @Override
    @Transactional
    public void removeCuisine(Cuisine cuisine) {
        cuisineDao.removeCuisine(cuisine);
    }

    /**
     * {@method setCuisineDao(CuisineDao categoriesDao)}
     * for tests services. Inject in this class
     */

    public void setCuisineDao(CuisineDao categoriesDao) {
        this.cuisineDao = categoriesDao;
    }
}