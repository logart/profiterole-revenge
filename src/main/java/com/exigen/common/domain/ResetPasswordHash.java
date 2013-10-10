package com.exigen.common.domain;

import javax.persistence.*;

/**
 * Class  {@code AbstractHashOfAccount} is used to reset
 *  password for user
 * @author  Elena  Vasilkovich
 * Date 27.05.13
 *
 */
@Entity
@DiscriminatorValue("P")
public class ResetPasswordHash extends AbstractHashOfAccount {
}
