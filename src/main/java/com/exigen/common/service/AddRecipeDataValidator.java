package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
     * {@code title} Contains pattern for check steps
     */
    private Pattern stepPattern = Pattern.compile("[^а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q,()+-=“”\"'‘’:;[]!?*%<>/\\E]");

    /**
     * {@code title} Contains pattern for check ingredient's count
     */
    private Pattern ingredientCountPattern = Pattern.compile("[^0-9]");

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
        Matcher stepMatcher;
        Matcher ingredientCountMatcher;
        int i = 0;
        for (String step : data.getStepsList()) {
            stepMatcher = stepPattern.matcher(step);
            if (stepMatcher.find()) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Корректными значениями являются большие и маленькие буквы" +
                        " (English, Українська, Русский), цифры, символы (, ( ) + - = “ ” \" ' ‘ ’ : ; [] ! ? * % <> / ).");
            }
            if (step.length() > 3000) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Размер шага не должен превышать 3000 символов.");
            }
            if (step.isEmpty()) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Поле не должно быть пустым.");
            }
            i++;
        }
        if (i == 0) {
            errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Должен быть хотя бы один шаг.");
        }

        for (i = 0; i < data.getIngredientsNameList().size(); i++) {
            data.setIngredientsCountList(i, data.getIngredientsCountList().get(i).trim());
            ingredientCountMatcher = ingredientCountPattern.matcher(data.getIngredientsCountList().get(i));
            if (data.getIngredientsNameList().get(i).isEmpty()) {
                errors.rejectValue("ingredientsTypeList[" + i + "]", "ingredientsTypeList[" + i + "].empty", "Выберите название ингридиента.");
            }
            if (data.getIngredientsCountList().get(i).isEmpty()) {
                errors.rejectValue("ingredientsTypeList[" + i + "]", "ingredientsTypeList[" + i + "].empty", "Введите количество ингридиента.");
            }
            if (data.getIngredientsTypeList().get(i).isEmpty()) {
                errors.rejectValue("ingredientsTypeList[" + i + "]", "ingredientsTypeList[" + i + "].empty", "Выберите тип измерения ингридиента.");
            }
            if (ingredientCountMatcher.find()) {
                errors.rejectValue("ingredientsTypeList[" + i + "]", "ingredientsTypeList[" + i + "].empty", "Корректными значениями количества ингридиента является целое число.");
            }
        }
        if (i == 0) {
            errors.rejectValue("ingredientsTypeList[" + i + "]", "ingredientsTypeList[" + i + "].empty", "Должен быть хотя бы один ингридиент.");
        }
    }
}
