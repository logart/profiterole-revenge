package com.exigen.common.service;

/**
 * Class  {@code ServiceException } is used for throws all ServiceException in
 * Service business logic
 *
 * @author Victoria Ganzha
 * @Date 23.05.13
 */
public class ServiceException extends Exception {

    /**
     * {@method ServiceException} its a default ServiceException constructor
     */

    public ServiceException(){
    }

    /**
     * {@method ServiceException (Throwable cause)} its a  ServiceException constructor
     */

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
