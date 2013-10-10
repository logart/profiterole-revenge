package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Class {@code AccountUser} is an ordinary user defined Java class whose instances
 * can be stored in the database. This entity created for users,
 * who registered in Profiterole
 *
 * @author Ivan
 * @date Feb 24,2013
 */
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "AccountUser.findAllUsers", query = "SELECT ac FROM AccountUser ac"),
        @NamedQuery(name = "AccountUser.findUserByLogin", query = "SELECT i FROM AccountUser i WHERE i.login LIKE :login"),
        @NamedQuery(name = "AccountUser.findUserByEmail", query = "SELECT i FROM AccountUser i WHERE i.email = :email")
})
public class AccountUser extends AbstractAccount implements Serializable {

    /**
     * {@code serialVersionUID}  Contains serialVersionUID
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * {@code maleOrFemale} contains gender of user
     */
    @Enumerated
    private Gender maleOrFemale;

    /**
     * {@code  country} contains name of country
     */

    private String country;

    /**
     * {@code dateOfBirth} contains date of birth of user
     */
    @Temporal(value = TemporalType.DATE)
    private Calendar dateOfBirth;


    /**
     * {@method AccountUser} its a default constructor for JPA
     */
    protected AccountUser() {

    }

    /**
     * {@method AccountUser} its a constructor for adding data in entity
     */
    public AccountUser(String login, String password, String email) {
        super(login, password, email);
        setRole(RoleConstants.ROLE_INACTIVE_USER);
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

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }


}
