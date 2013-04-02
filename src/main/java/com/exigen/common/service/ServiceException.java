package com.exigen.common.service;

/**
 * Class  {@code ServiceException} is used for throws exception in Service business
 *  logic
 * @author Victoria Ganzha
 * Date 29.03.13
 */
public class ServiceException extends Exception{
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
