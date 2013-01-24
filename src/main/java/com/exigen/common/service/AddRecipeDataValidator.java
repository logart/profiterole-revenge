package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class {@code AddRecipeDataValidator} is an ordinary Java class whose instances
 * can validate instances of AddRecipeData type.
 *
 * @author Oleg Kalinichenko
 * @date January 02, 2013
 */
public class AddRecipeDataValidator implements Validator {
    /**
     * {@code stepPattern} Contains pattern for check steps
     */
    private Pattern stepPattern = Pattern.compile("[^а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q,()+-=“”\"'‘’:;[]!?*%<>/\\E]");

    /**
     * {@code ingredientCountPattern} Contains pattern for check ingredient's count
     */
    private Pattern ingredientCountPattern = Pattern.compile("[^0-9]");

    /**
     * {@code MAX_STEP_SIZE} Contains maximum length of step text
     */
    private static final int MAX_STEP_SIZE = 3000;

    /**
     * {@code ingredientsTypeList} Contains name of bean where ingredient's error should be add
     */
    private static final String ingredientsTypeList = "ingredientsTypeList";

    /**
     * {@code ingredientsTypeList} Contains name of bean where step's error should be add
     */
    private static final String stepsList = "stepsList";

    /**
     * {@method supports(Class<?> aClass)}
     *
     * @param aClass(Class of posted object)
     * @return if passed object of type AddRecipeData returns true
     *         else return false
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return AddRecipeData.class.isAssignableFrom(aClass);
    }

    /**
     * {@method validate(Object o, Errors errors)}
     * for check all input data, and if something wrong,
     * add errors to instance errors
     *
     * @param o(The object what should be checked)
     * @param errors(Instance of Errors,where send all errors)
     */
    @Override
    public void validate(Object o, Errors errors) {
        AddRecipeData data = (AddRecipeData) o;
        data.setIngredientsCountList(trimList(data.getIngredientsCountList()));
        data.setStepsList(trimList(data.getStepsList()));
        checkSteps(data.getStepsList(), errors);
        checkIngredientsCount(data.getIngredientsCountList(), errors);
        checkIngredientsName(data.getIngredientsNameList(), errors);
        checkIngredientsType(data.getIngredientsTypeList(), errors);
        checkForEmptyLists(data.getIngredientsCountList(), data.getIngredientsTypeList(), data.getIngredientsNameList(), data.getStepsList(), errors);
    }

    /**
     * {@method checkSteps(List<String> stepsList, Errors errors)}
     * method for check text of steps, and if something wrong,
     * add errors to instance errors
     *
     * @param stepsList(List of steps text)
     * @param errors(Instance of Errors,where send all errors)
     */
    private void checkSteps(List<String> stepsList, Errors errors) {
        Matcher stepMatcher;
        for (int i = 0; i < stepsList.size(); i++) {
            stepMatcher = stepPattern.matcher(stepsList.get(i));
            if (stepsList.get(i).isEmpty()) {
                errors.rejectValue(this.stepsList + "[" + i + "]", "emptyStep." + this.stepsList, "Поле не должно быть пустым.");
            } else if (stepMatcher.find()) {
                errors.rejectValue(this.stepsList + "[" + i + "]", "wrongText." + this.stepsList, "Корректными значениями являются большие и маленькие буквы" +
                        " (English, Українська, Русский), цифры, символы (, ( ) + - = “ ” \" ' ‘ ’ : ; [] ! ? * % <> / ).");
            } else if (stepsList.get(i).length() > MAX_STEP_SIZE) {
                errors.rejectValue(this.stepsList + "[" + i + "]", "tooLong." + this.stepsList, "Размер шага не должен превышать 3000 символов.");
            }
        }
    }

    /**
     * {@method trimList(List<String> list)}
     * method for trim all elements of list
     *
     * @param list(List of steps text)
     * @return the list of all the transmitted elements, where removed
     *         all spaces at the beginning and at the end
     */
    private List<String> trimList(List<String> list) {
        for (String string : list) {
            string = string.trim();
        }
        return list;
    }

    /**
     * {@method checkIngredientsName(List<String> namesList, Errors errors)}
     * method for check text of ingredients name, and if something wrong,
     * add errors to instance errors
     *
     * @param namesList(List of ingredients name)
     * @param errors(Instance of Errors,where send all errors)
     */
    private void checkIngredientsName(List<String> namesList, Errors errors) {
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).isEmpty()) {
                errors.rejectValue(this.ingredientsTypeList + "[" + i + "]", "emptyName." + this.ingredientsTypeList, "Выберите название ингридиента.");
            }
        }
    }

    /**
     * {@method checkIngredientsType(List<String> typesList, Errors errors)}
     * method for check text of ingredients type, and if something wrong,
     * add errors to instance errors
     *
     * @param typesList(List of ingredients type)
     * @param errors(Instance of Errors,where send all errors)
     */
    private void checkIngredientsType(List<String> typesList, Errors errors) {
        for (int i = 0; i < typesList.size(); i++) {
            if (typesList.get(i).isEmpty()) {
                errors.rejectValue(this.ingredientsTypeList + "[" + i + "]", "emptyType." + this.ingredientsTypeList, "Выберите тип измерения ингридиента.");
            }
        }
    }

    /**
     * {@method checkIngredientsCount(List<String> countsList, Errors errors)}
     * method for check text of ingredients count, and if something wrong,
     * add errors to instance errors
     *
     * @param countsList(List of ingredients count)
     * @param errors(Instance of Errors,where send all errors)
     */
    private void checkIngredientsCount(List<String> countsList, Errors errors) {
        Matcher ingredientCountMatcher;
        for (int i = 0; i < countsList.size(); i++) {
            ingredientCountMatcher = ingredientCountPattern.matcher(countsList.get(i));
            if (countsList.get(i).isEmpty()) {
                errors.rejectValue(this.ingredientsTypeList + "[" + i + "]", "emptyCount." + this.ingredientsTypeList, "Введите количество ингридиента.");
            } else if (ingredientCountMatcher.find()) {
                errors.rejectValue(this.ingredientsTypeList + "[" + i + "]", "wrongCount." + this.ingredientsTypeList, "Корректными значениями количества ингридиента является целое число.");
            }
        }
    }

    /**
     * {@method checkForEmptyLists(List<String> countsList, List<String> typesList, List<String> namesList, List<String> stepsList, Errors errors)}
     * method for check that ingredient list and step list have at least
     * one element
     *
     * @param stepsList(List of steps text)
     * @param namesList(List of ingredients name)
     * @param countsList(List of ingredients count)
     * @param typesList(List of ingredients type)
     * @param errors(Instance of Errors,where send all errors)
     */
    private void checkForEmptyLists(List<String> countsList, List<String> typesList, List<String> namesList, List<String> stepsList, Errors errors) {
        if (countsList.size() == 0 || typesList.size() == 0 || namesList.size() == 0) {
            errors.rejectValue(this.ingredientsTypeList + "[0]", "zeroIngredients." + this.ingredientsTypeList, "Должен быть хотя бы один ингридиент.");
        }
        if (stepsList.size() == 0) {
            errors.rejectValue(this.stepsList + "[0]", "zeroSteps." + this.stepsList, "Должен быть хотя бы один шаг.");
        }
    }

}
