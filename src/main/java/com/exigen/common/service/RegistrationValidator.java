package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 17.02.13
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RegistrationValidator implements Validator {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationData.class.isAssignableFrom(aClass);
    }

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
