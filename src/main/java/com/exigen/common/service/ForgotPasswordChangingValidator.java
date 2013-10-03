package com.exigen.common.service;

import com.exigen.common.domain.ChangeForgottenPasswordData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Class  {@code ForgotPasswordChangingValidator} is used to validate
 *  passwords fields to be equals for reset password
 * @autor
 * @Date 29.03.13
 *
 */

@Component
public class ForgotPasswordChangingValidator implements Validator{


    @Override
    public boolean supports(Class<?> aClass) {
        return ChangeForgottenPasswordData.class.isAssignableFrom(aClass);
    }

    /**
     *  validate(Object target, Errors errors)
     * for check email and if something wrong,
     * add errors to instance errors
     *
     * @param target(The object what should be checked)
     * @param errors(Instance of Errors,where send all errors)
     */

    @Override
    public void validate(Object target, Errors errors){
        ChangeForgottenPasswordData passwordDTO = (ChangeForgottenPasswordData)target;

        if ( ! passwordDTO.getPassword().equals(passwordDTO.getPasswordConfirm())){
            errors.rejectValue("password", "passwordsNotSame.password", "Введенные пароли не совпадают");
        }

    }


}
