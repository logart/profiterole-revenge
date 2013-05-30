package com.exigen.common.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class  {@code HashesOfAccount} is used to reset
 *  password for user
 * @author  Elena  Vasilkovich
 * Date 27.05.13
 *
 */
@Entity
@DiscriminatorValue("P")
public class AccountPasswordReset extends HashesOfAccount{
}
