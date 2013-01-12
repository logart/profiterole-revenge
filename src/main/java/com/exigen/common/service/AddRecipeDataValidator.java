package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 08.12.12
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
public class AddRecipeDataValidator implements Validator {
    private Pattern stepPattern = Pattern.compile("[^а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q,()+-=“”\"'‘’:;[]!?*%<>/\\E]");

    @Override
    public boolean supports(Class<?> aClass) {
        return AddRecipeData.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AddRecipeData data = (AddRecipeData) o;
        Matcher stepMatcher;
        int i = 0;
        for (String step : data.getStepsList()) {
            stepMatcher = stepPattern.matcher(step);
            if (stepMatcher.find()) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Корректными значениями являются большие и маленькие буквы" +
                        " (English, Українська, Русский), цифры, символы (, ( ) + - = “ ” \" ' ‘ ’ : ; [] ! ? * % <> / )");
            }
            if (step.length() > 3000) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Размер шага не должен превышать 3000 символов");
            }
            if (step.isEmpty()) {
                errors.rejectValue("stepsList[" + i + "]", "stepsList[" + i + "].empty", "Поле не должно быть пустым");
            }
            i++;
        }


    }
}
