package com.exigen.common.service;

/**
 * Class {@code SendMailService}  used for send mail massage
 *
 * @author Elena Vasilkovich
 * @date April 5,2013
 *
 */
public interface SendMailService {
    /**
     * {@method sendMail(String hash, String login, String email)}
     * for send mail message
     *
     * @param hash (object of the hash)
     * @param login (object of the Account.login)
     * @param email (object of the Account.email)
     *
     */
    void sendMail(String hash, String login, String email) ;
}
