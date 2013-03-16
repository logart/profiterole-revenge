package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Class {@code Account} is an ordinary user defined Java class whose instances
 * can be stored in the database. This entity created for users,
 * who registered in Profiterole
 *
 * @author Ivan
 * @date Feb 24,2013
 */
@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findAllUsers", query = "SELECT ac FROM Account ac"),
        @NamedQuery(name = "Account.findUserByLogin", query = "SELECT i FROM Account i WHERE i.login LIKE :login")
})
public class Account implements Serializable {

    /**
     * {@code id} contains id of account
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code login} contains user's login
     */
    private String login;

    /**
     * {@code password} contains password for authentication
     */
    private String password;

    /**
     * {@code email} contains email address
     */
    private String email;

    /**
     * {@code maleOrFemale} contains gender of user
     */
    @Enumerated
    private Gender maleOrFemale;

    /**
     * {@code dateOfBirth} contains date of birth of user
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar dateOfBirth;

    /**
     * {@code dateOfBirth} contains the role of user
     */
    private String role = "ROLE_USER";

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
