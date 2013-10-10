package com.exigen.common.domain;

import javax.persistence.*;

/**
 * Class  {@code AbstractAccount} This entity created for users,
 * who registered in Profiterole.
 * @author Victoria Ganzha
 * @date 31.08.13
 *
 */



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries( {
        @NamedQuery(name = "AbstractAccount.findUserByLogin", query = "SELECT i FROM AbstractAccount i WHERE i.login LIKE:login") }
)

public abstract class AbstractAccount{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String login;

    private String password;

    @Column(unique = true)
    private String email;

    private String role;

    protected AbstractAccount(){

    }

    public AbstractAccount(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
