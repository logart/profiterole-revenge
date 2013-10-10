package com.exigen.common.service;

import com.exigen.common.domain.IngredientType;

/**
 * Class {@code IngredientTypeService} used for get, add and remove objects
 * from IngredientType entity with helps SpringTransaction JPA
 * @author Victoria Ganzha
 * @date  20.06.13
 *
 */
public interface IngredientTypeService {


    /**
     * {@method getIngredientTypeById(Integer typeId)}
     *
     * @param typeId
     * @return the  object of IngredientType, where Id =@param).
     */
    IngredientType getIngredientTypeById(Integer typeId);

    /**
     * {@method addIngredientType(IngredientType type)}
     * add the object of IngredientType for DB.
     * @param  type
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
