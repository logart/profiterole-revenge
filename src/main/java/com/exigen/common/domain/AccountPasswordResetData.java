package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class  {@code AccountPasswordResetData} is used to reset
 *  password for user
 * @author Victoria Ganzha
 * Date 29.03.13
 *
 */

@Entity
@Table(name = "account_pass_reset")
@NamedQueries({
        @NamedQuery(name = "AccountPasswordResetData.findByHash", query = "SELECT h FROM AccountPasswordResetData h WHERE hash = :hash")
})
public class AccountPasswordResetData  implements Serializable {


    /**
     * {@code id} contains id of account
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code hash} contains hash of account
     */

    private String hash;

    /**
     * {@code account} reference to the object account
     */
    @OneToOne
    private Account account;

    /**
     * {methods get .. and set..} its a getters and setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
