package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Locale;
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
     * {@code MIN_COOKING_HOURS_SIZE} Contains minimum value of cooking time for hour
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
     * {@code MIN_DISH_OUTPUT} Contains coefficient of minimum value of finished dish
     */
    private static final float MIN_DISH_OUTPUT = 0.25f;

    /**
     * {@code COOKING_TIME_MINUTES} Contains name of bean where ingredient's error should be add
     */
    private static final String WRONG_VALUE = "wrongValue.";

    /**
     * {@code cookingTimeHoursValue} Contains hours of cooking time
     */
    private Integer cookingTimeHoursValue;

    /**
     * {@code cookingTimeMinutesValue} Contains minutes of cooking time
     */
    private Integer cookingTimeMinutesValue;

    /**
     * {@code quantityOfDish} Contains grams of the finished dish
     */
    private Integer quantityOfDish;

    @Autowired
    private MeasureBucketService measureBucketService;

    @Autowired
    private MessageSource messageSource;

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
     * {@method setRecipeDao(RecipeDao recipeDao)}
     * for tests services. Inject in this class
     */

    public void setMeasureBucketService(MeasureBucketService measureBucketService) {
        this.measureBucketService = measureBucketService;
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
//        checkCookingTimeHours(this.cookingTimeHoursValue, errors);
//        checkCookingTimeMinutes(this.cookingTimeHoursValue, this.cookingTimeMinutesValue, errors);
//        checkQuantityOfDish(data.getQuantityOfDish(), data.getIngredientsCountList(), data.getIngredientsTypeList(),
//                data.getIngredientsNameList(), errors);
//        checkSteps(data.getStepsList(), errors);
//        checkIngredientsCount(data.getIngredientsCountList(), errors);
//        checkIngredientsName(data.getIngredientsNameList(), errors);
//        checkIngredientsType(data.getIngredientsTypeList(), errors);
//        checkForEmptyLists(data.getIngredientsCountList(), data.getIngredientsTypeList(), data.getIngredientsNameList(), data.getStepsList(), errors);
        data.setTitle(HtmlUtils.htmlEscape(data.getTitle()));
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
               errors.rejectValue("cookingTime","addRecipeDataValidator.cookingTimeMinutes.length","TRALIVALITRALIVALITRALIVALI");
            }


        } catch (NumberFormatException ex){
            errors.rejectValue("cookingTime","addRecipeDataValidator.cookingTime.numberFormatException",messageSource.getMessage("addRecipeDataValidator.cookingTime.numberFormatException", null, Locale.getDefault()));
//           errors.rejectValue("cookingTime","addRecipeDataValidator.cookingTime.numberFormatException","TRALIVALITRALIVALITRALIVALI");
        }

    }


//    /**
//     * {@method checkSteps(List<String> stepsList, Errors errors)}
//     * method for check text of steps, and if something wrong,
//     * add errors to instance errors
//     *
//     * @param stepsList(List of steps text)
//     * @param errors(Instance of Errors,where send all errors)
//     */
//    private void checkSteps(List<String> stepsList, Errors errors) {
//        Matcher stepMatcher;
//        for (int i = 0; i < stepsList.size(); i++) {
//            stepMatcher = stepPattern.matcher(stepsList.get(i));
//            if (stepsList.get(i).isEmpty()) {
//                errors.rejectValue("stepsList", "addRecipeDataValidator.stepsList.isEmpty");
//            } else if (stepMatcher.find()) {
//                errors.rejectValue("stepsList", "addRecipeDataValidator.stepMatcher.find");
//            } else if (stepsList.get(i).length() > MAX_STEP_SIZE) {
//                errors.rejectValue("stepsList", "addRecipeDataValidator.stepsList.size");
//            }
//        }
//    }

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

//    /**
//     * {@method checkIngredientsName(List<String> namesList, Errors errors)}
//     * method for check text of ingredients name, and if something wrong,
//     * add errors to instance errors
//     *
//     * @param namesList(List of ingredients name)
//     * @param errors(Instance of Errors,where send all errors)
//     */
//    private void checkIngredientsName(List<String> namesList, Errors errors) {
//        for (int i = 0; i < namesList.size(); i++) {
//            if (namesList.get(i).isEmpty()) {
//                errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.namesList.isEmpty",null,Locale.getDefault()));
//            }
//        }
//    }

//    /**
//     * {@method checkIngredientsType(List<String> typesList, Errors errors)}
//     * method for check text of ingredients type, and if something wrong,
//     * add errors to instance errors
//     *
//     * @param typesList(List of ingredients type)
//     * @param errors(Instance of Errors,where send all errors)
//     */
//    private void checkIngredientsType(List<String> typesList, Errors errors) {
//        for (int i = 0; i < typesList.size(); i++) {
//            if (typesList.get(i).isEmpty()) {
//                errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.typesList.isEmpty",null,Locale.getDefault()));
//            }
//        }
//    }
//
//    /**
//     * {@method checkIngredientsCount(List<String> countsList, Errors errors)}
//     * method for check text of ingredients count, and if something wrong,
//     * add errors to instance errors
//     *
//     * @param countsList(List of ingredients count)
//     * @param errors(Instance of Errors,where send all errors)
//     */
//    private void checkIngredientsCount(List<String> countsList, Errors errors) {
//        for (int i = 0; i < countsList.size(); i++) {
//            if (countsList.get(i).isEmpty()) {
//                errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.countList.isEmpty",null,Locale.getDefault()));
//            }else {
//                try {
//                    if (Float.parseFloat(countsList.get(i).replace(',','.')) < MIN_INGREDIENT_COUNT_VALUE || Float.parseFloat(countsList.get(i).replace(',','.')) > MAX_INGREDIENT_COUNT_VALUE) {
//                        errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.countList.length",null,Locale.getDefault()));
//                    }
//                } catch (NumberFormatException ex) {
//                    errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.countList.length",null,Locale.getDefault()));
//                }
//            }
//        }
//    }



//    /**
//     * {@method checkCookingTimeHours(Errors errors)}
//     * method for check text of cooking time, and if something wrong,
//     * add errors to instance errors
//     */
//    private void checkCookingTimeHours(Integer cookingTimeHoursValue, Errors errors) {
//
//        if (cookingTimeHoursValue > MAX_COOKING_HOURS_SIZE || cookingTimeHoursValue < MIN_COOKING_HOURS_SIZE) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.cookingTimeHours.length",null,Locale.getDefault()));
//        }
//    }
//
//    /**
//     * {@method checkCookingTimeMinutes(Errors errors)}
//     * method for check text of cooking time, and if something wrong,
//     * add errors to instance errors
//     */
//    private void checkCookingTimeMinutes(Integer cookingTimeHoursValue, Integer cookingTimeMinutesValue, Errors errors) {
//
//        if  (cookingTimeHoursValue == 0 && (cookingTimeMinutesValue < MIN_COOKING_TIME_SIZE ||
//                cookingTimeMinutesValue > MAX_COOKING_MINUTES_SIZE)) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.cookingTimeHoursMinutes.values",null,Locale.getDefault()));
//            return;
//        }
//
//        if  ((cookingTimeHoursValue > 0 && cookingTimeHoursValue < MAX_COOKING_HOURS_SIZE) &&
//                (cookingTimeMinutesValue < MIN_COOKING_HOURS_SIZE ||cookingTimeMinutesValue >
//                MAX_COOKING_MINUTES_SIZE)) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.cookingTimeHoursMinutes.values",null,Locale.getDefault()));
//            return;
//        }
//
//        if  (cookingTimeHoursValue == MAX_COOKING_HOURS_SIZE && cookingTimeMinutesValue >
//                MIN_COOKING_HOURS_SIZE) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.cookingTimeHoursMinutes.values",null,Locale.getDefault()));
//        }
//    }


    /**
     * {@method checkQuantityOfDish(String quantityOfDish, Errors errors)}
     * method for check text of quantity of dish, and if something wrong,
     * add errors to instance errors
     *
     * @param quantityOfDish (quantity of dish of recipe)
     */
//    private void checkQuantityOfDish(String quantityOfDish, List<String> countsList, List<String> typesList,
//                                     List<String> namesList, Errors errors) {
//
//        try {
//            if (quantityOfDish.isEmpty()) {
//                errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.quantityOfDish.isEmpty",null,Locale.getDefault()));
//                return;
//            } else {
//                this.quantityOfDish = Integer.parseInt(quantityOfDish);
//            }
//
//        } catch (NumberFormatException ex){
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.quantityOfDish.numberFormatException",null,Locale.getDefault()));
//            return;
//        }
//        if (countsList.size() != 0 && typesList.size() != 0 && namesList.size() != 0) {
//            int weightAllIngredients = 0;
//            MeasuresBucket measuresBucket;
//            for (int i=0; i < typesList.size(); i++) {
//                measuresBucket = measureBucketService.getMeasuresBucketListById(Integer.parseInt(typesList.get(i)));
//                weightAllIngredients += Integer.parseInt(countsList.get(i))*measuresBucket.getGramEquals();
//            }
//            if (this.quantityOfDish > weightAllIngredients || this.quantityOfDish < weightAllIngredients * MIN_DISH_OUTPUT){
//                errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.quantityOfDish.weightAllIngredients", new Object[weightAllIngredients], Locale.getDefault()));
//            }
//        }
//
//    }

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
//    private void checkForEmptyLists(List<String> countsList, List<String> typesList, List<String> namesList, List<String> stepsList, Errors errors) {
//        if (countsList.size() == 0 || typesList.size() == 0 || namesList.size() == 0) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.countsList.typesList.namesList.size", null, Locale.getDefault()));
//        }
//        if (stepsList.size() == 0) {
//            errors.getFieldError(messageSource.getMessage("addRecipeDataValidator.stepsList.null",null,Locale.getDefault()));
//        }
//    }

}
