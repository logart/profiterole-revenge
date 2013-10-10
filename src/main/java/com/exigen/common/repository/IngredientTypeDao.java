package com.exigen.common.repository;

import com.exigen.common.domain.IngredientType;

/**
 * Class {@code IngredientType} used for get, add and remove objects
 * from IngredientType entity with helps JPA
 * @author Victoria Ganzha
 * @date  20.06.13
 *
 */

public interface IngredientTypeDao {

    /**
     * {@method getIngredientTypeById(Integer typeId)}
     *
     * @param typeId
     * @return the  object of IngredientType, where Id =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureId is null, or has no results in the database)
     */
    IngredientType getIngredientTypeById(Integer typeId);

    /**
     * {@method addIngredientType(IngredientType type)}
     * add the object of IngredientType for DB.
     * @param type
     *
     */
    void addIngredientType(IngredientType type);

    /**
     * {@method removeIngredientType(IngredientType type)}
     * remove the object of IngredientType from DB.
     * @param type
     *
     */
    void removeIngredientType(IngredientType type);


}

