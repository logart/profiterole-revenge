package com.exigen.common.service;

import com.exigen.common.domain.Recipe;

import java.util.List;

/**
 * Interface {@code SearchService} use for show search results
 *
 * @author Volodymyr Samokhval
 * @date April 20,2013
 */
public interface SearchService {

    /**
     * {@method getFoundedRecipesList(String searchingUnit)}
     *
     * @param searchingUnit (object for search)
     * @return all founded recipes list
     */

    List<Recipe> getFoundedRecipesList(String searchingUnit);
}
