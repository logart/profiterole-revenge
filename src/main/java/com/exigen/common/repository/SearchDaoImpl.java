package com.exigen.common.repository;

import com.exigen.common.domain.Recipe;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Class  {@code SearchDaoImp} is used for
 * search recipe on the index
 *
 * @author Victoria Ganzha
 * @date 17.04.13
 */


@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {

    private static final String[] FIELD_NAMES = new String[]{"title", "description"};

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method doIndexing() }
     * for indexing recipe with every update and restart
     *
     */

    @PostConstruct
    public void doIndexing(){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        try{
        fullTextEntityManager.createIndexer().startAndWait();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * {@method searchRecipe ( final String searchTerm) }
     * for indexing entity and search recipe on index
     *
     * @param searchTerm
     * @return the list of find recipes
     *
     */
    @Override
    public List<Recipe> searchRecipe ( final String searchTerm) {

        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity( Recipe.class ).get();
        org.apache.lucene.search.Query query = qb
                .keyword()
                .onFields(FIELD_NAMES)
                .matching(searchTerm)
                .createQuery();

        Query persistenceQuery =
                fullTextEntityManager.createFullTextQuery(query, Recipe.class);


        return persistenceQuery.getResultList();

    }



}

