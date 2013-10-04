package com.exigen.common.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * Class {@code AccountData} is a class that contains the user's
 * account data what he edit in view form
 *
 * @author Lena
 * @date Mar 13, 2013
 */
public class AccountData implements Serializable {
    /**
     * {@code serialVersionUID}  Contains serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private static final int MIN_LENGTH_OF_PASS=6;

    private static final int  MAX_LENGTH_OF_PASS=35;

    private static final int MIN_LENGTH_OF_LOGIN=3;

    private static final int MAX_LENGTH_OF_LOGIN=50;

    private static final int MAX_LENGTH_OF_EMAIL=250;

    /**
     * {@code login} describes username
     */
    @Size(min = MIN_LENGTH_OF_LOGIN, max = MAX_LENGTH_OF_LOGIN, message = "{accountData.size.login}")
    @Pattern(regexp="^[a-zA-Z0-9\\Q.+-();:_\\E]*$",message = "{accountData.pattern.login}")
    private String login;

    /**
     * {@code password} describes password for edit
     */
    @Size(min = MIN_LENGTH_OF_PASS, max = MAX_LENGTH_OF_PASS, message = "{accountData.size.password}")
    @Pattern(regexp="^[\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*/=-]*$",message ="{accountData.size.pattern}")
    private String password;

    /**
     * {@code email} describes email address
     */
    @Size(max = MAX_LENGTH_OF_EMAIL,message = "{accountData.size.email}")
//    @Email (message = "{accountData.email.email}")
    private String email;

    /**
     * {@code dateOfBirth} describes date of birth of some user
     */

    @Pattern(regexp="^(([0-2]\\d|3[0,1])\\.(0[1-9]|1[0-2])\\.((19|20)\\d{2})){0,1}$",message = "{accountData.pattern.dateOfBirth}")
    private String dateOfBirth;

    private String maleOrFemale;

    private String country;

    @Pattern(regexp="^$|^([\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*\\/\\=\\-]{6,35})$",message ="{accountData.pattern.changePassword}")
    private String changePassword;

    private String confirmPassword;


    /**
     * {@methods get .. and set..} its a getters and setters
     */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    public void setMaleOrFemale(String maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(String changePassword) {
        this.changePassword = changePassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
