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
     * {@method sendMail(String message, String email)}
     * for send mail message
     *
     * @param message (Object message  generate by NotificationService, for send specific mail massage)
     * @param email (object of the AccountUser.email, for send mail message on specific email)
     *
     */
    void sendMail(String message, String email) throws NotificationException;
}
