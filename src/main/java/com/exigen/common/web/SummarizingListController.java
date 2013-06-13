package com.exigen.common.web;

import com.exigen.common.service.IngredientBucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Class  {@code SummarizingListController} is used to create
 * modal window with information about chosed recipes
 *
 * @author Dimyc
 * @DATE November 16, 2012
 */

@Controller
public class SummarizingListController {

    /**
     * {@code ingridientService} describes the IngridientService for inject on this
     * class
     */

    @Autowired
    private IngredientBucketService ingredientBucketService;

    /**
     * {@method summarizingListController()} using for mapped ajax queries      *
     *
     * @return information about chosed recipes in modal window
     */

    @RequestMapping(value = "/summarizingList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelAndView summarizingListController(HttpServletRequest request) {
        Map <String, String[]> params = request.getParameterMap();
        Map <Integer, Integer> ids = new HashMap<Integer, Integer>(params.size());
        for (Map.Entry<String,String[]> entry: params.entrySet()){
            Integer recipeId = Integer.parseInt(entry.getKey());
            Integer recipeIdCount = Integer.parseInt(entry.getValue()[0]);
            ids.put(recipeId, recipeIdCount);
        }

        return new ModelAndView("summarizingList", "model", this.ingredientBucketService
                .getAllIngredientBuckets(ids));
    }
}
