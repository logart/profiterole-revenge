package com.exigen.common.service;

import com.exigen.common.domain.AccountData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Class {@code EditProfileValidator} is an ordinary Java class whose instances
 * can validate instances of RegistrationData type.
 *
 * @author Elena Vasilkovich
 * @date May 31, 2013
 */
@Component
public class EditProfileValidator implements Validator {

    /**
     * {@method supports(Class<?> aClass)}
     *
     * @param aClass(Class of posted object)
     * @return if passed object of type RegistrationData returns true
     *         else return false
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return AccountData.class.isAssignableFrom(aClass);
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
        AccountData data = (AccountData) target;

        if (!data.getChangePassword().equals(data.getConfirmPassword())){
            errors.rejectValue("changePassword", "passwordNotConfirm.password", "Пароль должен быть повторен.");
        }
    }
}
