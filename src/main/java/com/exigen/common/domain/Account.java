package com.exigen.common.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Class {@code Account} is an ordinary user defined Java class whose instances
 * can be stored in the database. This entity created for users,
 * who registered in Profiterole
 *
 * @author Ivan
 * @date Jan 30,2013
 */
@Entity
@Table(name = "accounts")
@NamedQuery(name = "Account.findAllUsers", query = "SELECT ac FROM Account ac")
public class Account implements Serializable {

    private static final int MINLENGTH = 3;
    private static final int MAXLENGTH =50;

    /**
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     */
    @Id
    @GeneratedValue
    private Integer id;


    /**
     * {@code login} describes username
     */
    @NotEmpty(message = "Поле должно быть указано.")
    private String login;

    /**
     * {@code password} describes password for authentification
     */
    @NotEmpty(message = "Поле должно быть указано.")
    @Size(min = MINLENGTH, max = MAXLENGTH)
    private String password;

    /**
     * {@code email} describes email address for some user
     */
    @NotEmpty(message = "Поле должно быть указано.")
    @Email
    private String email;

    /**
     * {@code maleOrFemale} describes sex of some user
     */
    @Enumerated
    private Gender maleOrFemale;

    /**
     * {@code dateOfBirth} describes date of birth of some user
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar dateOfBirth;

    /**
     * {@method Account} its a default constructor for JPA
     */
    public Account() {

    }

    /**
     * {@method Account} its a constructor for adding data in entity
     */
    public Account(String login, String password, String email, Gender maleOrFemale, Calendar dateOfBirth) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.maleOrFemale = maleOrFemale;
        this.dateOfBirth = dateOfBirth;
    }


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

    public Gender getMaleOrFemale() {
        return maleOrFemale;
    }

    public void setMaleOrFemale(Gender maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }


    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
