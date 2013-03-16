package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Class {@code RegistrationValidator} is an ordinary Java class whose instances
 * can validate instances of RegistrationData type.
 *
 * @author Oleg Kalinichenko
 * @date February 15, 2013
 */
@Component
public class RegistrationValidator implements Validator {
    /**
     * {@code accountService} Contains implementation of AccountService interface
     */
    @Autowired
    private AccountService accountService;

    /**
     * {@method supports(Class<?> aClass)}
     *
     * @param aClass(Class of posted object)
     * @return if passed object of type AddRecipeData returns true
     *         else return false
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationData.class.isAssignableFrom(aClass);
    }

    /**
     * {@method validate(Object o, Errors errors)}
     * for check all input data, and if something wrong,
     * add errors to instance errors
     *
     * @param target(The object what should be checked)
     * @param errors(Instance of Errors,where send all errors)
     */
    @Override
    public void validate(Object target, Errors errors) {
        RegistrationData data = (RegistrationData) target;
        String login = data.getLogin();
        Account account = accountService.findByUsername(login);
        if (account != null) {
            errors.rejectValue("login", "loginAlreadyExist.login", "Пользователь с таким логином уже существует.");
        }
    }
}
