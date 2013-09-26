package com.exigen.common.web;

import com.exigen.common.domain.Recipe;
import com.exigen.common.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Interface {@code SearchController} used for show search results
 *
 * @author Volodymyr Samokhval
 * @date April 20,2013
 */

@Controller
public class SearchController {

    /**
     * {@code SearchService} describes the SearchService for inject on this
     * class
     */

    @Autowired
    private SearchService searchService;

    /**
     * {@method searchResults()} using for get search results
     *
     * @param searchingUnit entered search query
     * @return all founded recipes list
     */
    @RequestMapping(value = {"/searchResults", "/searchNoResults"})
    public ModelAndView searchResults(@RequestParam("searchUnit") String searchingUnit) {

        if (searchingUnit == null || searchingUnit.trim().isEmpty() || searchingUnit.length() > 30){
            return new ModelAndView("searchNoResults");
        }
        List<Recipe> foundedResults = this.searchService.getFoundedRecipesList(searchingUnit);
        if (foundedResults == null || foundedResults.isEmpty()){
            return new ModelAndView("searchNoResults");
        }
        return new ModelAndView("searchResults", "model", foundedResults);
    }
}
