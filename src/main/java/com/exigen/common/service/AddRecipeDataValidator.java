package com.exigen.common.service;

import com.exigen.common.domain.AddRecipeData;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 08.12.12
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
public class AddRecipeDataValidator implements Validator{
    @Override
    @SuppressWarnings("unchecked")
    public boolean supports(Class<?> aClass) {
        return AddRecipeData.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
