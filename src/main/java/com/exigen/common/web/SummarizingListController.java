package com.exigen.common.web;

import com.exigen.common.service.IngredientBucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping(value = {"/summarizingList"})
    @ResponseBody
    public ModelAndView summarizingListController(@RequestParam("recipesId") List<Integer> recipesId) {
        return new ModelAndView("summarizingList", "model", this.ingredientBucketService
                .getAllIngredientBuckets(recipesId));
    }
}
