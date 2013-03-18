package com.exigen.common.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * Class {@code EditProfileData} is a class that contains the user's
 * account data what he edit in view form
 *
 * @author A.Kondratiev
 * @date Mar 13, 2013
 */
public class EditProfileData implements Serializable {

    private static final int MIN_LENGTH_OF_PASS=6;

    private static final int  MAX_LENGTH_OF_PASS=35;

    /**
     * {@code login} describes username
     */

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
    @Email (message = "Введите корректный e-mail.")
    private String email;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
