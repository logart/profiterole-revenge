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

    /**
     * {@method Cuisine} its a default constructor for JPA
     */

    public Cuisine() {
    }

    /**
     * {@method Cuisine} its a constructor for adding data in entity
     */

    public Cuisine(String cuisin, String imglink) {
        this.cuisin = cuisin;
        this.imglink = imglink;
    }

    /**
     * {@method getCuisineId()} its a getter
     */

    public Integer getCuisineId() {
        return cuisineId;
    }

    /**
     * {@method setCuisineId()} its a setter
     */

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    /**
     * {@method getCuisin()} its a getter
     */

    public String getCuisin() {
        return cuisin;
    }

    /**
     * {@method setCuisin} its a setter
     */


    public void setCuisin(String cuisin) {
        this.cuisin = cuisin;
    }

    /**
     * {@method getRecipes()} its a getter
     */

    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * {@method setRecipes} its a setter
     */

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * {@method getImglink()} its a getter
     */

    public String getImglink() {
        return imglink;
    }

    /**
     * {@method setImglink} its a setter
     */


    public void setImglink(String imglink) {
        this.imglink = imglink;
    }
}