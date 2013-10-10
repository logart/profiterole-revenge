package com.exigen.common.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class {@code AccountUAdmin} is an user-admin defined Java class whose instances
 * can be stored in the database.
 *
 * @author Victoria Ganzha
 * @date 31.08.13
 */


@Entity
@Table(name = "admin")
public class AccountAdmin extends AbstractAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    protected AccountAdmin() {

    }

    public AccountAdmin(String login, String password, String email) {
        super(login, password, email);
        setRole(RoleConstants.ROLE_ADMIN);
    }


}
