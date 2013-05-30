package com.exigen.common.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Class  {@code ActivationHash} is used to activation of account
 *   for user
 * @author Elena Vasilkovich
 * Date 27.05.13
 *
 */
@Entity
@DiscriminatorValue("A")
public class ActivationHash extends HashesOfAccount {
}
