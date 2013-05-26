package com.exigen.common.service;

/**
 * Class  {@code NotificationException} is used for throws specific NotificationException in Service business
 *  logic
 *
 * @author Victoria Ganzha
 * @Date 23.05.13
 */
public class NotificationException extends ServiceException {


    /**
     * {@method NotificationException} its a default NotificationException constructor
     */
    public NotificationException() {

    }

    /**
     * {@method NotificationException(Throwable cause)} its a NotificationException constructor
     */

    public NotificationException(Throwable cause) {
        super(cause);
    }

}
