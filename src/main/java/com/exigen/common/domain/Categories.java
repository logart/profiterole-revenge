package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Class {@code Recipe} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan
 * @date July 17,2012
 */
@Entity
@Table(name = "categories")
public class Categories implements Serializable {
    /**
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     * the class is created on July 25, 2012 the author Sergey_
     */
    @Id
    @GeneratedValue
    private Integer categoriesId;

    /**
     * {@code categ} describes name of category
     */
    private String categ;


    /**
     * {@code recipeList} it's list of recipes in Categories. Realization of a two-way communication between the entities recipes and cuisines
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private List<Recipe> recipeList;

    /**
     * {@method Categories} its a default constructor for JPA
     */

    public Categories() {
    }

    /**
     * {@method Categories} its a constructor for adding data in entity
     */

    public Categories(String categ) {
        this.categ = categ;
    }

    /**
     * {@method getCategoriesId()} its a getter
     */

    public Integer getCategoriesId() {
        return categoriesId;
    }

    /**
     * {@method setCategoriesId()} its a setter
     */

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    /**
     * {@method getCateg()} its a getter
     */

    public String getCateg() {
        return categ;
    }

    /**
     * {@method setCateg} its a setter
     */

    public void setCateg(String categ) {
        this.categ = categ;
    }

    /**
     * {@method getRecipeList()} its a getter
     */

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    /**
     * {@method setRecipeList} its a setter
     */


    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}