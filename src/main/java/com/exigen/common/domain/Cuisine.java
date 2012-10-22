package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Class  is an ordinary user defined Java class whose instances
 * can be stored in the database.
 */
@Entity
@Table(name = "cuisine")
public class Cuisine implements Serializable {
    /**
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     * the class is created on July 25, 2012 the author Sergey_
     */
    @Id
    @GeneratedValue
    private Integer cuisineId;

    /**
     * {@code cuisin} describes name of our cuisines
     */
    private String cuisin;

    /**
     * {@code imglink} describes reference for images
     */
    private String imglink;


    /**
     * {@code recipes} it's list of recipes in Cuisine. Realization of a two-way communication between the entities recipes and cuisines
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuisine")
    private List<Recipe> recipes;


    public Cuisine() {
    }

    public Cuisine(String cuisin, String imglink) {
        this.cuisin = cuisin;
        this.imglink = imglink;
    }

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisin() {
        return cuisin;
    }

    public void setCuisin(String cuisin) {
        this.cuisin = cuisin;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }
}
