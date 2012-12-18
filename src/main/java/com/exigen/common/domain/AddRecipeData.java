package com.exigen.common.domain;

import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
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
    @NotEmpty (message = "Поле должно быть указано.")
    @Size(max = 250, message = "Количество символов не должно превышать 250 символов.")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q.,()[]+-*/=\"'\\E]*$", message = "Корректными значениями являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(,()[]+-*/=\"'')")
    private String title;

    /**
     * {@code description} This field is intended to describe the recipe.
     */

    @NotEmpty (message = "Поле должно быть указано.")
    @Size(max=3000, message = "Количество символов не должно превышать 3000 символов.")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\Q(.,()+-=\"':;[]!?*%<>/\\E]*$", message = "Корректными значениями являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(.,()+-=\"':;[]!?*%<>/)", flags = javax.validation.constraints.Pattern.Flag.MULTILINE)
    private String description;

    /**
     * {@code cookingTime} This field contains cooking time.
     */
    @NotEmpty (message = "Поле должно быть указано.")
    @Pattern(regexp = "^[0-9]*$", message = "Должно быть целым числом.")
    @Min(value = 6, message = "Корректное значение лежит в диапазоне от 6 до 540 (целые).")
    @Max(value = 540, message = "Корректное значение лежит в диапазоне от 6 до 540 (целые).")
    private String cookingTime;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity.
     */
    @Valid
    private Cuisine cuisine;

    /**
     * {@code category} This field is a reference to the Categories entity.
     */
    @Valid
    private Categories category;

    /**
     * {@code ingredientList} This field contains list of ingredients for meal.
     * Ingredients are a references to the Ingridient entity.
     */

    private String[] ingredientsNameList;
    private String[] ingredientsCountList;
    private String[] ingredientsTypeList;
    /**
     * {@code ingredientList} This field contains list of steps for meal
     */

    @NotEmpty(message = "Должен быть минимум 1 шаг приготовления.")
    private String[] stepsList;

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

    public String[] getIngredientsNameList() {
        return ingredientsNameList;
    }

    public void setIngredientsNameList(String[] ingredientsNameList) {
        this.ingredientsNameList = ingredientsNameList;
    }

    public String[] getIngredientsCountList() {
        return ingredientsCountList;
    }

    public void setIngredientsCountList(String[] ingredientsCountList) {
        this.ingredientsCountList = ingredientsCountList;
    }

    public String[] getIngredientsTypeList() {
        return ingredientsTypeList;
    }

    public void setIngredientsTypeList(String[] ingredientsTypeList) {
        this.ingredientsTypeList = ingredientsTypeList;
    }

    public String[] getStepsList() {
        return stepsList;
    }

    public void setStepsList(String[] stepsList) {
        this.stepsList = stepsList;
    }


}
