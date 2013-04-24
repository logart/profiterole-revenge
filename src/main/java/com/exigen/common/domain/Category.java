package com.exigen.common.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class {@code Category} is an ordinary category defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan
 * @date Feb 24,2013
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    /**
     * {@code id} contains id of category
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * {@code name} describes name of category
     */
    @NotEmpty(message = "Поле должно быть указано.")
    private String name;

    /**
     * {@code recipeList} it's list of recipes in category.
     * Realization of a two-way communication between the entities recipes and cuisines
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Recipe> recipeList;

    /**
     * {@method Category} its a default constructor for JPA
     */
    public Category() {
    }

    /**
     * {@method Category} its a constructor for adding data in entity
     */
    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Recipe> recipeList) {
        this.name = name;
        this.recipeList = recipeList;
    }

    /**
     * {@methods get .. and set..} its a getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}