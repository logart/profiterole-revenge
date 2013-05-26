package com.exigen.common.service;

import java.util.Map;

/**
 * Class {@code NotificationService}
 * used for generate specific message
 *
 * @author Victoria Ganzha
 * @date May 21,2013
 *
 */
public interface NotificationService {

    /**
     * {@method String getRequestBaseURL()}
     * used for get common URL from servlet
     *
     */

    String getRequestBaseURL();

    /**
     * {@method generateMessage(String template, Map <String, String> dataModel)
     * for generate message
     *
     * @param template (String freemarker template name, used for specific content in message)
     * @param datamodel (Includes responseURL, commonURL, login )
     *
     */

    String generateMessage(String template, Map<String, String> dataModel) throws NotificationException;

    /**
     * {@method createResetPasswordMessage(String hash, String login)}
     *
     * @param hash (String of a hash, unique hash code used for generate URL)
     * @param login (object of an Account.login, login name of user, used for generate message)
     * @return String message
     */

    String createResetPasswordMessage(String hash, String login) throws NotificationException;
}
