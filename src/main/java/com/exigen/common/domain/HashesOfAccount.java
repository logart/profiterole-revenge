package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class  {@code HashesOfAccount} is used to activation of account and to reset
 *  password for user
 * @author Victoria Ganzha
 * Date 29.03.13
 *
 */

@Entity
@Table(name = "hashes_of_account")
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
        @NamedQuery(name = "HashesOfAccount.findByHash", query = "SELECT h FROM HashesOfAccount h WHERE h.hash = :hash")

})
abstract public class HashesOfAccount implements Serializable {
//public class HashesOfAccount implements Serializable {


    /**
     * {@code serialVersionUID}  Contains serialVersionUID
     */
    private static final long serialVersionUID = 1L;

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

    @Column(name = "discriminator", updatable=false,insertable = false )
    private String discriminator;


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

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}
