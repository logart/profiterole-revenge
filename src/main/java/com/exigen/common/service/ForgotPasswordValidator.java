package com.exigen.common.service;

import com.exigen.common.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Class  {@code ForgotPasswordValidator} is used to validate
 *  email for reset password
 * @autor Victoria Ganzha
 * @Date 29.03.13
 *
 */

@Component
public class ForgotPasswordValidator implements Validator{

    /**
     * {@code accountService} Contains implementation of AccountService interface
     */

    @Autowired
    private AccountService accountService;

    /**
     * @param aClass(Class of posted object)
     * @return if passed object of type AddRecipeData returns true
     *         else return false
     */

    @Override
    public boolean supports(Class<?> aClass) {
        return String.class.isAssignableFrom(aClass);
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
        String email = (String)target;
        if(email == null || email.trim().isEmpty()){
            errors.reject("email.empty", "Поле не должно быть пустым.");
            return;
        }

        Account account = accountService.findByEmail(email);
        if ( account == null){
            errors.reject("emailNotExist.email", "Пользователь  с данным e-mail адрессом не зарегистрирован.");
        }

    }


}
