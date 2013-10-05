package com.exigen.common.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Anatolii Kondratiev
 * Date: 03.04.13
 * Time: 1:29
 * is a class that contains the hash and password
 * data what user edit in view form
 */
public class ChangeForgottenPasswordData {

    private static final int MIN_LENGTH_OF_PASS = 6;

    private static final int MAX_LENGTH_OF_PASS = 35;

    /**
     * {@code password} describes password for edit
     */
    @NotEmpty(message = "Поле не должно быть пустым. Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ).")
    @Size(min = MIN_LENGTH_OF_PASS, max = MAX_LENGTH_OF_PASS, message = "Длина пароля должна быть от " + MIN_LENGTH_OF_PASS + " до " + MAX_LENGTH_OF_PASS + " символов.")
    @Pattern(regexp = "^[\\x28\\x29\\x5b\\x5d\\x2e,;:а-яА-ЯіІїЇєЄёЁ\\w\\+\\*/=-]*$", message = " Корректными значениями являются большие и маленькие буквы (Русский, Украинский, Английский), цифры, символы (, . + - * / () [] = : ; _ ). ")
    private String password, passwordConfirm;

    /**
     * {@code hash} contains hash
     */

    private String hash;

    /**
     * {methods get .. and set..} its a getters and setters
     */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String password) {
        this.passwordConfirm = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
