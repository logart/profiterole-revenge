package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.stereotype.Component;
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
@Component
public class AddRecipeDataValidator implements Validator {
    /**
     * {@code MAX_COOKING_HOURS_SIZE} Contains maximum value of cooking time for hour
     */
    private static final int MAX_COOKING_HOURS_SIZE = 9;

    /**
     * {@code MIN_COOKING_HOURS_SIZE} Contains maximum value of cooking time for hour
     */
    private static final int MIN_COOKING_HOURS_SIZE = 0;

    /**
     * {@code MIN_COOKING_TIME_SIZE} Contains minimum value of cooking time for hour
     */
    private static final int MIN_COOKING_TIME_SIZE = 6;

    /**
     * {@code MAX_COOKING_MINUTES_SIZE} Contains maximum value of cooking time for minutes
     */
    private static final int MAX_COOKING_MINUTES_SIZE = 59;

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
     * {@code COOKING_TIME_MINUTES} Contains name of bean where ingredient's error should be add
     */
    private static final String WRONG_VALUE = "wrongValue.";
    /**
     * {@code COOKING_TIME_MINUTES} Contains name of bean where ingredient's error should be add
     */
    private static final String COOKING_TIME_MINUTES = "cookingTimeMinutes";

   /**
     * {@code INGREDIENTS_TYPE_LIST} Contains name of bean where ingredient's error should be add
     */
    private static final String INGREDIENTS_TYPE_LIST = "ingredientsTypeList";

    /**
     * {@code INGREDIENTS_TYPE_LIST} Contains name of bean where step's error should be add
     */
    private static final String STEPS_LIST = "stepsList";

    /**
     * {@code cookingTimeHoursValue} Contains hours of cooking time
     */
    private Integer cookingTimeHoursValue;

    /**
     * {@code cookingTimeMinutesValue} Contains minutes of cooking time
     */
    private Integer cookingTimeMinutesValue;

    /**
     * {@code COOKING_MINUTES_ERROR_MESSAGE} massage of cooking time minutes error
     */
    private static final String  COOKING_MINUTES_ERROR_MESSAGE = "Если не указаны часы времени приготовления, " +
            "корректное значение для минут лежит в диапазоне от " + MIN_COOKING_TIME_SIZE + " минут до " +
            MAX_COOKING_MINUTES_SIZE + " минут (целые), если часы указаны - значение для минут лежит в диапазоне от " +
            MIN_COOKING_HOURS_SIZE + " минут до " + MAX_COOKING_MINUTES_SIZE + " минут (целые), " +
            "но не более 9 часов.";

    /**
     * {@code COOKING_MINUTES_ERROR_MESSAGE} massage of cooking time minutes error
     */
    private static final String INGREDIENT_COUNT_ERROR_MESSAGE = "Корректное значение лежит в диапазоне от " +
            MIN_INGREDIENT_COUNT_VALUE + " до " + MAX_INGREDIENT_COUNT_VALUE + ".";

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
        checkCookingTimeNotEmptyNotLiteral(data.getCookingTimeMinutes(), data.getCookingTimeHours(), errors);
        checkCookingTimeHours(this.cookingTimeHoursValue, errors);
        checkCookingTimeMinutes(this.cookingTimeHoursValue, this.cookingTimeMinutesValue, errors);
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
        for (int i =0; i < list.size(); i++) {
            list.set(i, list.get(i).trim());
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
                        errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]",
                                WRONG_VALUE + this.INGREDIENTS_TYPE_LIST, INGREDIENT_COUNT_ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    errors.rejectValue(this.INGREDIENTS_TYPE_LIST + "[" + i + "]",
                            WRONG_VALUE + this.INGREDIENTS_TYPE_LIST, INGREDIENT_COUNT_ERROR_MESSAGE);
                }
            }
        }
    }

   /**
    * {@method checkCookingTimeNotEmptyNotLiteral(String cookingTimeHours, String cookingTimeMinutes,Errors errors)}
    * method for check text of cooking time, and if something wrong,
    * add errors to instance errors
    *
    * @param cookingTimeHours (hours of cooking time)
    * @param cookingTimeMinutes (minutes of cooking time)
    */
   private void checkCookingTimeNotEmptyNotLiteral(String cookingTimeMinutes, String cookingTimeHours, Errors errors) {

       try {
           if (cookingTimeHours.isEmpty()) {
               this.cookingTimeHoursValue = 0;
           } else {
                this.cookingTimeHoursValue = Integer.parseInt(cookingTimeHours);
           }

           if (cookingTimeMinutes.isEmpty()) {
               this.cookingTimeMinutesValue = 0;
           } else {
               this.cookingTimeMinutesValue = Integer.parseInt(cookingTimeMinutes);
           }

           if (this.cookingTimeMinutesValue == 0 && this.cookingTimeHoursValue == 0) {
               errors.rejectValue(this.COOKING_TIME_MINUTES, WRONG_VALUE + this.COOKING_TIME_MINUTES,
                       "Время приготовления должно быть указано. Корректное значение лежит в диапазоне от " +
                               MIN_COOKING_TIME_SIZE + " минут до " + MAX_COOKING_HOURS_SIZE + " часов (целые).");
           }

       } catch (NumberFormatException ex){
           errors.rejectValue(this.COOKING_TIME_MINUTES, WRONG_VALUE + this.COOKING_TIME_MINUTES,
                   "Корректное значение для часов приготовления лежит в диапазоне от " + MIN_COOKING_HOURS_SIZE +
                           " часов до " + MAX_COOKING_HOURS_SIZE + " часов, для минут - " + MIN_COOKING_HOURS_SIZE +
                           " минут до" + MAX_COOKING_MINUTES_SIZE + " минут (целые), " +
                           "но не менее 6 минут и не более 9 часов");
       }
   }

    /**
     * {@method checkCookingTimeHours(Errors errors)}
     * method for check text of cooking time, and if something wrong,
     * add errors to instance errors
     */
    private void checkCookingTimeHours(Integer cookingTimeHoursValue, Errors errors) {

        if (cookingTimeHoursValue > MAX_COOKING_HOURS_SIZE || cookingTimeHoursValue < MIN_COOKING_HOURS_SIZE) {
            errors.rejectValue(this.COOKING_TIME_MINUTES, WRONG_VALUE + this.COOKING_TIME_MINUTES,
                    "Корректное значение для часов приготовления лежит в диапазоне от " + MIN_COOKING_HOURS_SIZE +
                            " часов до " + MAX_COOKING_HOURS_SIZE + " часов (целые).");
        }
    }

    /**
     * {@method checkCookingTimeMinutes(Errors errors)}
     * method for check text of cooking time, and if something wrong,
     * add errors to instance errors
     */
    private void checkCookingTimeMinutes(Integer cookingTimeHoursValue, Integer cookingTimeMinutesValue, Errors errors) {

        if  (cookingTimeHoursValue == 0 && (cookingTimeMinutesValue < MIN_COOKING_TIME_SIZE ||
                cookingTimeMinutesValue > MAX_COOKING_MINUTES_SIZE)) {
            errors.rejectValue(COOKING_TIME_MINUTES, WRONG_VALUE + COOKING_TIME_MINUTES,
                    COOKING_MINUTES_ERROR_MESSAGE);

        }

        if  ((cookingTimeHoursValue > 0 && cookingTimeHoursValue < MAX_COOKING_HOURS_SIZE) &&
                (cookingTimeMinutesValue < MIN_COOKING_HOURS_SIZE ||cookingTimeMinutesValue >
                MAX_COOKING_MINUTES_SIZE)) {
            errors.rejectValue(COOKING_TIME_MINUTES, WRONG_VALUE + COOKING_TIME_MINUTES,
                    COOKING_MINUTES_ERROR_MESSAGE);

        }

        if  (cookingTimeHoursValue == MAX_COOKING_HOURS_SIZE && cookingTimeMinutesValue >
                MIN_COOKING_HOURS_SIZE) {
            errors.rejectValue(COOKING_TIME_MINUTES, WRONG_VALUE + COOKING_TIME_MINUTES,
                    COOKING_MINUTES_ERROR_MESSAGE);

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
