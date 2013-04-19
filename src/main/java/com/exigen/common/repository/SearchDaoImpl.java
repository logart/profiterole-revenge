package com.exigen.common.repository;

import com.exigen.common.domain.Recipe;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class  {class SearchDaoImp} is used for
 * search recipe on the index
 * @author Victoria Ganzha
 * date 17.04.13
 */

@Repository("searchDao")
public class SearchDaoImpl implements SearchDao, InitializingBean {

    private static final String[] FIELD_NAMES = new String[]{"title", "description"};

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * for indexing db with every update and restart
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();
    }

    /**
     * method for indexing entity and search recipe
     * param searchTerm
     * return result of search
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

        javax.persistence.Query persistenceQuery =
                fullTextEntityManager.createFullTextQuery(query, Recipe.class);

        List<Recipe> result = persistenceQuery.getResultList();
        return result;

    }



}

