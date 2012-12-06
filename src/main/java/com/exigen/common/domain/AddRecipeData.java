package com.exigen.common.domain;

import org.hibernate.validator.constraints.*;

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
    @NotEmpty (message = "Название должно быть указано.")
    @Size(max = 250, message = "Название содержит недопустимое количество символов (до 250).")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q.,()[]+-*/=\"'\\E]*$", message = "Корректными значениями названия являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(,()[]+-*/=\"'')")
    private String title;

    /**
     * {@code description} This field is intended to describe the recipe.
     */

    @NotEmpty (message = "Описание должно быть указано.")
    @Size(max=3000, message = "Длина описания не должна превышать 3000 символов.")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\Q(.,()+-=\"':;[]!?*%<>/\\E]*$", message = "Корректными значениями описания являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(.,()+-=\"':;[]!?*%<>/)", flags = javax.validation.constraints.Pattern.Flag.MULTILINE)
    private String description;

    /**
     * {@code cookingTime} This field contains cooking time.
     */
    @NotEmpty (message = "Время приготовления должно быть указано.")
    @Pattern(regexp = "^[0-9]*$", message = "Время приготовления должно быть целым числом.")
    @Min(value = 6, message = "Корректное значение времени приготовления лежит в диапазоне от 6 до 540 (целые).")
    @Max(value = 540, message = "Корректное значение времени приготовления лежит в диапазоне от 6 до 540 (целые).")
    private String cookingTime;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity.
     */

    private Cuisine cuisine;

    /**
     * {@code category} This field is a reference to the Categories entity.
     */
    @NotNull(message = "Категория должна быть обязательно выбрана")
    private Categories category;

    /**
     * {@code ingredientList} This field contains list of ingredients for meal.
     * Ingredients are a references to the Ingridient entity.
     */

    @NotEmpty(message = "Должен быть минимум 1 ингридиент.")
    @Size(min=1, max = 3, message = "ошибъка ингридлиентов")
    private String[] ingredientList;

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

    public String[] getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String[] ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String[] getStepsList() {
        return stepsList;
    }

    public void setStepsList(String[] stepsList) {
        this.stepsList = stepsList;
    }


}
