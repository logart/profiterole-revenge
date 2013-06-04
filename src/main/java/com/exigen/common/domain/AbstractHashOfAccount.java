package com.exigen.common.domain;

import javax.persistence.*;


/**
 * Class  {@code AbstractHashOfAccount} is used to activation of account and to reset
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
     * {@code hash} contains hash of account
     */

    @Id
    private String hash;

    /**
     * {@code account} reference to the object account
     */
    @OneToOne
    private Account account;

    /**
     * {methods get .. and set..} its a getters and setters
     */

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
