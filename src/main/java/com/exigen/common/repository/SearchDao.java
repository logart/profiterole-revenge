package com.exigen.common.repository;

import com.exigen.common.domain.Recipe;
import java.util.List;

/**
 * Interface  {interface SearchDao} is used for
 * search recipe on the index
 * @author Victoria Ganzha
 * date 17.04.13
 */
public interface SearchDao {

    /**
     * method for indexing entity and search recipe
     * param searchTerm
     * return result of search
     */

    List<Recipe> searchRecipe ( final String searchTerm);

}
