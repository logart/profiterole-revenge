package com.exigen.common.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Class  {@code ActivationHash} is used to activation of account
 *   for user
 * @author Elena Vasilkovich
 * Date 27.05.13
 *
 */
@Entity
@DiscriminatorValue("A")
@NamedQueries({
        @NamedQuery(name = "ActivationHash.findByHash", query = "SELECT a FROM ActivationHash a WHERE a.hash = :hash")
})
public class ActivationHash extends HashesOfAccount {
}
