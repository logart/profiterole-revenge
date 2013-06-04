package com.exigen.common.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Class  {@code HashesOfAccount} is used to reset
 *  password for user
 * @author  Elena  Vasilkovich
 * Date 27.05.13
 *
 */
@Entity
@DiscriminatorValue("P")
@NamedQueries({
        @NamedQuery(name = "AccountPasswordReset.findByHash", query = "SELECT p FROM AccountPasswordReset p WHERE p.hash = :hash")
})
public class AccountPasswordReset extends HashesOfAccount{
}
