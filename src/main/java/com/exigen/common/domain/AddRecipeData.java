package com.exigen.common.domain;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
/**
 * Class {@code AddRecipeData} is an ordinary recipe defined Java class whose instances
 * can be stored in the database.
 *
 * @author Oleg Kalinichenko
 * @date December 02, 2012
 */
public class AddRecipeData implements Serializable {

    /**
     * {@code title} Contains the title of recipe.
     */

    @Size(max = 200, min=5, message = "Название содержит недопустимое количество символов (от 5 до 200).")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z0-9 \\Q!?,().\"':;%\\E]*$", message = "Название содержит недопустимые символы.")
    private String title;

    /**
     * {@code description} This field is intended to describe the recipe.
     */

    @Size(min=10, message = "Слишком короткое описание.")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z0-9 \\Q!?,.()-+*&`\"':;%\\E]*$", message = "Название содержит недопустимые символы.")
    private String description;

    /**
     * {@code cookingTime} This field contains cooking time.
     */

    @NotEmpty (message = "Время приготовления должно быть указано.")
    @Pattern(regexp = "^[0-9]*$", message = "Время приготовления должно быть целым числом.")
    private String cookingTime;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity.
     */

    private Cuisine cuisine;

    /**
     * {@code category} This field is a reference to the Categories entity.
     */

    private Categories category;

    /**
     * {@code ingredientList} This field contains list of ingredients for meal.
     * Ingredients are a references to the Ingridient entity.
     */

    @NotNull(message = "Должен быть минимум 1 ингридиент.")
    private List<Ingridient> ingredientList;

    /**
     * {@code ingredientList} This field contains list of steps for meal
     */

    @NotNull(message = "Должен быть минимум 1 шаг приготовления.")
    private List<Step> stepsList;

    public AddRecipeData(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<Ingridient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingridient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Step> getStepsList() {
        return stepsList;
    }

    public void setStepsList(List<Step> stepsList) {
        this.stepsList = stepsList;
    }


}
