package com.exigen.common.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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

    private static final int MIN_LENGTH_OF_PASS=6;

    private static final int  MAX_LENGTH_OF_PASS=35;

    private static final int MIN_LENGTH_OF_LOGIN=3;

    private static final int MAX_LENGTH_OF_LOGIN=50;

    private static final int MAX_LENGTH_OF_EMAIL=250;

    /**
     * {@code login} describes username
     */
    @NotEmpty(message = "Поле не должно быть пустым. Корректными значениями являются большие и маленькие буквы (Английский), цифры, символы (. + - () : ; _ ).")
    @Size(min = MIN_LENGTH_OF_LOGIN, max = MAX_LENGTH_OF_LOGIN, message = "Длина логина должна быть от " + MIN_LENGTH_OF_LOGIN + " до " + MAX_LENGTH_OF_LOGIN + " символов.")
    @Pattern(regexp="^[a-zA-Z0-9\\Q.+-();:_\\E]*$",message = "Корректными значениями являются большие и маленькие буквы (Английский), цифры, символы (. + - () : ; _ ).")
    private String login;

    /**
     * {@code password} describes password for edit
     */
    @NotEmpty(message = "Поле не должно быть пустым. Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ).")
    @Size(min = MIN_LENGTH_OF_PASS, max = MAX_LENGTH_OF_PASS, message = "Длина пароля должна быть от " + MIN_LENGTH_OF_PASS + " до " + MAX_LENGTH_OF_PASS + " символов.")
    @Pattern(regexp="^[\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*/=-]*$",message =" Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ). ")
    private String password;

    /**
     * {@code email} describes email address
     */
    @NotEmpty(message = "Поле не должно быть пустым.")
    @Size(max = MAX_LENGTH_OF_EMAIL,message = "Длина e-mail должна быть не больше 250 символов")
    @Email (message = "Введите корректный e-mail.")
    private String email;

    /**
     * {@code dateOfBirth} describes date of birth of some user
     */

    @Pattern(regexp="^(([0-2]\\d|3[0,1])\\.(0[1-9]|1[0-2])\\.((19|20)\\d{2})){0,1}$",message = "Дата рождения должна быть выбрана из календаря или заполнена самостоятельно в формате дд.мм.гггг.")
    private String dateOfBirth;

    private String maleOrFemale;

    private String country;


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
}
