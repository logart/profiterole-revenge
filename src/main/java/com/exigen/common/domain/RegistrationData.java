package com.exigen.common.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

//import javax.persistence.Enumerated;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
//import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 05.02.13
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationData implements Serializable {
    
    private final int minLengthOfLogin=3;

    private final int maxLengthOfLogin=50;
    
    private final int minLengthOfPass=6;

    private final int maxLengthOfPass=35;
    
    /**
     * {@code login} describes username
     */
    @NotEmpty(message = "Поле не должно быть пустым.")
    @Size(min = minLengthOfLogin, max = maxLengthOfLogin, message = "Длина логина должна быть от 3 до 50 символов.")
    @Pattern(regexp="^[\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*/=-]*$",message = "Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ).")
    private String login;

    /**
     * {@code password} describes password for authentification
     */
    @NotEmpty(message = "Поле не должно быть пустым.")
    @Size(min = minLengthOfPass, max = maxLengthOfPass, message = "Длина пароля должна быть от 6 до 35 символов.")
    @Pattern(regexp="^[\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*/=-]*$",message =" Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ). ")
    private String password;

    /**
     * {@code email} describes email address for some user
     */
    @NotEmpty(message = "Поле не должно быть пустым.")
    @Email (message = "Введите корректный e-mail.")
    private String email;


    /**
     * {@code dateOfBirth} describes date of birth of some user
     */
    @Pattern(regexp="^(([0-2]\\d|3[0,1])\\.(0[1-9]|1[0-2])\\.((19|20)\\d{2})){0,1}$",message = "Дата рождения должна быть выбрана из календаря или заполнена самостоятельно в формате дд.мм.гггг.")
    private String dateOfBirth;

    /**
     * {@code maleOrFemale} describes sex of some user
     */

    private String maleOrFemale;



    private String country;

    @NotEmpty(message = "Для завершения регистрации Вы должны принять Правила и условия работы на сайте.")
    private String iAmAgree;



    /**
     * {@methods get .. and set..} its a getters and setters
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


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

    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    public void setMaleOrFemale(String maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }


     public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getiAmAgree() {
        return iAmAgree;
    }

    public void setiAmAgree(String iAmAgree) {
        this.iAmAgree = iAmAgree;
    }
}
