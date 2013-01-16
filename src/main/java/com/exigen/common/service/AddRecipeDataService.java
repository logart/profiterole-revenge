package com.exigen.common.service;

import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Ingridient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface {@code AddRecipeDataService} used for add new recipe to DB, and for
 * editing input data
 *
 * @author Oleg
 * @date December 08,2012
 */
@Service("addRecipeDataService")
public class AddRecipeDataService {
    @Autowired
    private IngridientService ingridientService;
    public Categories getCategoryFromListByID(Integer id, List<Categories> list) {
        for (Categories c : list) {
            if (c.getCategoriesId() == id) {
                return c;
            }
        }
        return null;
    }

    public Cuisine getCuisineFromListByID(Integer id, List<Cuisine> list) {
        for (Cuisine c : list) {
            if (c.getCuisineId() == id) {
                return c;
            }
        }
        return null;
    }
    public List<Ingridient> getIngridientsFromData(String[] id, String[] counts, String[] types) {
        List<Ingridient> list = new ArrayList<Ingridient>();
        Ingridient ingr = new Ingridient();
        for(int i = 0; i < id.length; i++){
            Ingridient temp =  ingridientService.getIngridientById(Integer.parseInt(id[i]));
            ingr.setCountOfIngridient(Integer.parseInt(counts[i]));
            ingr.setNameOfIngridient(temp.getNameOfIngridient());
            ingr.setUnitOfMeasure(types[i]);
            ingr.setCalories(temp.getCalories());
            list.add(ingr);
        }
        return list;
    }
}
