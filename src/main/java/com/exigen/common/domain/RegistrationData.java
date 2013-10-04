package com.exigen.common.domain;

import javax.validation.constraints.Size;


/**
 * Class {@code RegistrationData} is a class that extends AccountData and contains the user's
 * account data what he input in Registration view form
 *
 * @author Lena
 * @date February 05, 2013
 */
public class RegistrationData extends AccountData  {
    /**
     * {@code serialVersionUID}  Contains serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Size(min=1,message = "{registrationData.size.iImAgree}")
    private String iAmAgree;

    /**
     * {@methods get .. and set..} its a getters and setters
     */

    public String getiAmAgree() {
        return iAmAgree;
    }

    public void setiAmAgree(String iAmAgree) {
        this.iAmAgree = iAmAgree;
    }
}
