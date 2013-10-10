package com.exigen.common.service;

import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class {@code SearchServiceImpl} use for show search results
 *
 * @author Volodymyr Samokhval
 * @date April 20,2013
 */
@Service("SearchService")
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {


    /**
     * {@code searchDao} describes the searchDao work with indexes
     */
    @Autowired
    private SearchDao searchDao;

    /**
     * {@method getFoundedRecipesList(String searchingUnit)}
     *
     * @param searchingUnit (object for search)
     * @return all founded recipes list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getFoundedRecipesList(String searchingUnit) {
        return searchDao.searchRecipe(searchingUnit);
    }
}
