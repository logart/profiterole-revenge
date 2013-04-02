package com.exigen.common.web;

import com.exigen.common.service.MeasureBucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Class  {@code MeasuresOfIngredientsController} used for get measures of Ingredient
 *
 * @author Oleg Kalinichenko
 * @DATE March 18, 2013
 */

@Controller
public class MeasuresOfIngredientsController {
    /**
     * {@code measureBucketService} describes the MeasuresBucket for inject on this
     * class
     */
    @Autowired
    private MeasureBucketService measureBucketService;

    /**
     * {@method getMeasures()} using for get id and names of measures of ingredient
     *
     * @return map, where key is id of measure, and value is name of measure
     */
    @RequestMapping(value = "/getMeasures", method = RequestMethod.GET)
    @ResponseBody
    public Map<Integer, String> getMeasures(@RequestParam Integer ingredientId) {
        return measureBucketService.getMeasuresBucketMapByIngredientId(ingredientId);
    }
}
