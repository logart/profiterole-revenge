package com.exigen.common.repository;

import com.exigen.common.domain.Recipe;
import java.util.List;

/**
 * Interface  {@code SearchDao} is used for
 * search recipe on the index
 * @author Victoria Ganzha
 * @date 17.04.13
 */
public interface SearchDao {

    /**
     *  {@method searchRecipe ( final String searchTerm)}
     *  for search recipe on index
     * @param searchTerm
     * @return for indexing entity and search recipe on index
     *
     */

    List<Recipe> searchRecipe ( final String searchTerm);

}
