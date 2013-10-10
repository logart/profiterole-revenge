package com.exigen.common.domain;


import javax.persistence.*;
import java.util.List;

/**
 * Class {@code Recipe} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan
 * @date Feb 24,2013
 */
@Entity
@Table(name = "cuisines")
public class Cuisine {


    /**
     * {@code id} contains id of cuisine
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * {@code name} describes name of our cuisines
     */
    private String name;

    /**
     * {@code imglink} describes reference for images
     */
    private String image;


    /**
     * {@code recipes} it's list of recipes in Cuisine.
     * Realization of a two-way communication between the entities recipes and cuisines
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuisine")
    private List<Recipe> recipeList;

    /**
     * {@method Cuisine} its a default constructor for JPA
     */
    public Cuisine() {
    }

    /**
     * {@method Cuisine} its a constructor for adding data in entity
     */
    public Cuisine(String name, String image) {
        this.name = name;
        this.image = image;
    }

    /**
     * {@methods get.. and set..} its a getters and setters
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}