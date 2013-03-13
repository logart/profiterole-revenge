package com.exigen.common.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code Steps} is an entity, what contains steps of recipes
 *
 * @author Ivan
 * @date Feb 24,2013
 */

@Entity
@Table(name = "steps")
@NamedQuery(name = "Step.findStepsAboutRecipe", query = "SELECT t FROM Step t WHERE t.recipe.id=:selectedRecipeId")
public class Step implements Serializable {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code stepNumber} describes the number of some step in this entity. Its showed in our views
     */
    @Column(nullable = false)
    private Integer number;

    /**
     * {@code stepDescription} describes some concretical part of recipe. Its showed in our views
     */
    @Column(columnDefinition = "mediumtext", nullable = false)
    private String description;

    /**
     * {@code stepImg} describes img for this step. Its showed in our views
     */
    @Column(columnDefinition = "mediumtext")
    private String image;

    /**
     * {@code recipe} this field to describe quantity of particular ingredient
     * in some recipe
     */
    @ManyToOne
    @JoinColumn(name = "recipeId", nullable = false)
    private Recipe recipe;

    /**
     * {@method Step} its a constructor for adding data in entity
     */
    public Step() {

    }

    public Step(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    public Step(Integer number, String description,  Recipe recipe) {
        this.number = number;
        this.description = description;
        this.recipe = recipe;
    }

    public Step(String description, String image, Integer number, Recipe recipe) {
        this.description = description;
        this.image = image;
        this.number = number;
        this.recipe = recipe;
    }

    /**
     * {@methods } below its a getters and setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}