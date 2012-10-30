package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Class {@code Recipe} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ulyana Kucheryavaya
 */
@Entity
@Table(name = "recipe")
@NamedQueries({
        @NamedQuery(name = "Recipe.findRecipesFromCuisine",
                query = "SELECT rp FROM Recipe AS rp WHERE rp.cuisine=:selectedCuisine"),
        @NamedQuery(name = "Recipe.findRecipeById",
                query = "SELECT rp FROM Recipe AS rp WHERE rp.id=:selectedId")
})

public class Recipe implements Serializable {
    /**
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     */
    @Id
    @GeneratedValue
    private Integer recipeId;

    /**
     * {@code title} describes name of recipe
     */
    private String title;

    /**
     * {@code description} this field is intended to describe the recipe
     */
    @Column(columnDefinition="mediumtext")
    private String description;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity
     */
    @ManyToOne
    @JoinColumn(name = "cuis_id", nullable = false)
    private Cuisine cuisine;

    /**
     * {@code categories} This field is a reference to the Categories entity
     */
    @ManyToOne
    @JoinColumn(name = "categ_id", nullable = false)
    private Categories categories;
    @Column(columnDefinition="mediumtext")
    private String bigImg;
    @Column(columnDefinition="mediumtext")
    private String smallImg;

    private Integer time;


    public Recipe() {
    }

    public Recipe(String title, String description, Cuisine cuisine, Categories categories, String bigImg, String smallImg, Integer time) {
        this.title = title;
        this.description = description;
        this.cuisine = cuisine;
        this.categories = categories;
        this.bigImg = bigImg;
        this.smallImg = smallImg;
        this.time = time;
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public float getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

