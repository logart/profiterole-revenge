package com.exigen.common.domain;

import javax.persistence.*;


/**
 * Class  {@code AbstractHashOfAccount} is used to activation of accountUser and to reset
 *  password for user
 * @author Victoria Ganzha
 * Date 29.03.13
 *
 */

@MappedSuperclass
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract  class AbstractHashOfAccount {

    /**
     * {@code hash} contains hash of accountUser
     */

    @Id
    private String hash;

    /**
     * {@code accountUser} reference to the object accountUser
     */
    @OneToOne
    private AccountUser accountUser;

    /**
     * {methods get .. and set..} its a getters and setters
     */

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

}
