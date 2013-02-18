package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.util.HtmlUtils;

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
    private Pattern stepPattern = Pattern.compile("[^а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\Q,.()+-=\"“”'‘’:;[]!?*%<>/\\E]");

    /**
     * {@code MAX_STEP_SIZE} Contains maximum length of step text
     */
    private static final int MAX_STEP_SIZE = 3000;

    /**
     * {@code MAX_INGREDIENT_COUNT_VALUE} Contains maximum value of ingredient's count
     */
    private static final int MAX_INGREDIENT_COUNT_VALUE = 1000;

    /**
     * {@code MIN_INGREDIENT_COUNT_VALUE} Contains minimum value of ingredient's count
     */
     private static final int MIN_INGREDIENT_COUNT_VALUE = 1;

   /**
     * {@code INGREDIENTS_TYPE_LIST} Contains name of bean where ingredient's error should be add
     */
    private static final String INGREDIENTS_TYPE_LIST = "ingredientsTypeList";

    /**
     * {@code INGREDIENTS_TYPE_LIST} Contains name of bean where step's error should be add
     */
    private static final String STEPS_LIST = "stepsList";

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
        data.setTitle(HtmlUtils.htmlEscape(data.getTitle()));
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
                errors.rejectValue(this.STEPS_LIST + "[" + i + "]", "emptyStep." + this.STEPS_LIST, "Поле не должно быть пустым.\n Длина описания шага должна быть от 1 до 3000 символов.\n Корректными значениями являются большие и маленькие буквы "+
                       " (Русский, Украинский, Английский), цифры, символы (, . () [] + - * / = “ ”  ‘ ’ : ; ! ? % <>).");
            } else if (stepMatcher.find()) {
                errors.rejectValue(this.STEPS_LIST + "[" + i + "]", "wrongText." + this.STEPS_LIST, "Корректными значениями являются большие и маленькие буквы" +
                        " (Русский, Украинский, Английский), цифры, символы (, . () [] + - * / = “ ”  ‘ ’ : ; ! ? % <>).");
            } else if (stepsList.get(i).length() > MAX_STEP_SIZE) {
                errors.rejectValue(this.STEPS_LIST + "[" + i + "]", "tooLong." + this.STEPS_LIST, " Длина описания шага должна быть от 1 до 3000 символов.");
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
    public List<String> trimList(List<String> list) {
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
                errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]", "emptyName." + this.INGREDIENTS_TYPE_LIST, "Название ингредиента должно быть выбрано.");
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
                errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]", "emptyType." + this.INGREDIENTS_TYPE_LIST, "Единица измерения ингредиента должна быть выбрана.");
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
        for (int i = 0; i < countsList.size(); i++) {
            if (countsList.get(i).isEmpty()) {
                errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]", "emptyCount." + this.INGREDIENTS_TYPE_LIST, "Количество ингредиента должно быть указано.Корректное значение лежит в диапазоне от " + MIN_INGREDIENT_COUNT_VALUE + " до " + MAX_INGREDIENT_COUNT_VALUE + ".");
            }else {
                try {
                    if (Float.parseFloat(countsList.get(i).replace(',','.')) < MIN_INGREDIENT_COUNT_VALUE || Float.parseFloat(countsList.get(i).replace(',','.')) > MAX_INGREDIENT_COUNT_VALUE) {
                        errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]", "wrongValue." + this.INGREDIENTS_TYPE_LIST, "Корректное значение лежит в диапазоне от " + MIN_INGREDIENT_COUNT_VALUE + " до " + MAX_INGREDIENT_COUNT_VALUE + ".");
                    }
                } catch (Exception ex) {
                    errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]", "wrongValue." + this.INGREDIENTS_TYPE_LIST, "Корректное значение лежит в диапазоне от " + MIN_INGREDIENT_COUNT_VALUE + " до " + MAX_INGREDIENT_COUNT_VALUE + ".");
                }
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
            errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[0]", "zeroIngredients." + this.INGREDIENTS_TYPE_LIST, "В рецепте должен быть хотя бы 1 ингредиент. ");
        }
        if (stepsList.size() == 0) {
            errors.rejectValue(this.STEPS_LIST + "[0]", "zeroSteps." + this.STEPS_LIST, "В рецепте должен быть хотя бы 1 шаг.");
        }
    }

}
