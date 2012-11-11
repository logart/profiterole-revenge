package com.exigen.common.domain;


import javax.persistence.*;

/**
 * Class {@code Steps} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan Guravel
 * @date November 9,2012
 */

@Entity
@Table(name = "steps")
public class Steps {

    /**
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     */

    @Id
    @GeneratedValue
    private Integer stepId;

     /**
     * {@code stepNumber} describes the number of some step in this entity. Its showed in our views
     */

     private Integer stepNumber;

    /**
     * {@code stepDescription} describes some concretical part of recipe. Its showed in our views
     */
    @Column(columnDefinition="mediumtext")
    private String stepDescription;

    /**
     * {@code stepImg} describes img for this step. Its showed in our views
     */
    @Column(columnDefinition="mediumtext")
    private String stepImg;



    /**
     * {@code recipe} This field created for add information about
     *  recipes in Steps entity. Steps its a new entity. Was Created in sprint number six
     *  Its contains field: stepId(unique Id in this table), nameOfStep(description name of step),
     * recipe(reference for recipe entity)
     */

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="recipest_id")
    private Recipe recipe;

    /**
     * {@method Steps} its a default constructor for JPA
     */
    public Steps(){

    }

    /**
     * {@method Steps} its a constructor for adding data in entity
     */

    public Steps(Integer stepNumber, String stepDescription, String stepImg, Recipe recipe) {
         this.stepNumber = stepNumber;
        this.stepDescription = stepDescription;
        this.stepImg = stepImg;
        this.recipe = recipe;
    }

    /**
     * {@methods } below its a getters and setters
     */


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public String getStepImg() {
        return stepImg;
    }

    public void setStepImg(String stepImg) {
        this.stepImg = stepImg;
    }
}
