package com.exigen.common.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class {@code NotificationService}
 * used for generate specific message
 *
 * @author Victoria Ganzha
 * @date May 21,2013
 *
 */

@Service ("notificationService")
public class NotificationServiceImpl implements NotificationService {

    protected static final Logger LOG = Logger.getLogger(NotificationServiceImpl.class.getName());

    public static final String CHANGE_FORGOTTEN_PASSWORD_URL = "changeForgottenPassword";

    public static final String ACTIVATION_URL = "activation";

    /**
     * {@code request} describes the HttpServletRequest to inject on this
     * class
     */
   @Autowired
    private HttpServletRequest request;

    /**
     * {@method String getRequestBaseURL()}
     * used for get common URL from servlet
     *
     */

    public String getRequestBaseURL(){
        StringBuilder commonURL = new StringBuilder();
        commonURL.append(request.getScheme())
                .append("://")
                .append(request.getServerName())
                .append("/")
                .append(request.getContextPath());

        return commonURL.toString();
    }

    /**
     * {@method generateMessage(String template, Map<String, String> dataModel)
     * for generate message
     *
     * @param template (String freemarker template name, used for specific content in message)
     * @param datamodel (Includes responseURL, commonURL, login )
     *
     */

    public String generateMessage(String template, Map<String, String> dataModel) throws NotificationException {

        Configuration cfg = new Configuration();

        cfg.setServletContextForTemplateLoading(request.getSession().getServletContext(),"WEB-INF/freemarker");
        StringWriter writer = new StringWriter();

        try{
            Template temp = cfg.getTemplate(template);
            temp.process(dataModel, writer);

        } catch(IOException e ) {
            LOG.log(Level.WARNING, "IOException when (temp = cfg.getTemplate)", e);
            throw new NotificationException(e);


        } catch (TemplateException e ) {
            LOG.log(Level.WARNING, "TemplateException when (temp.process())", e);
            throw new NotificationException(e);
        }

        return writer.toString();
    }


    /**
     * {@method createResetPasswordMessage(String hash, String login)}
     *
     * @param hash (String of a hash, unique hash code used for generate URL)
     * @param login (object of an AccountUser.login, login name of user, used for generate message)
     * @return String message
     */

    public String createResetPasswordMessage(String hash, String login) throws NotificationException {

        String commonURL = getRequestBaseURL();
        String responseURL = commonURL.concat(CHANGE_FORGOTTEN_PASSWORD_URL + "?hash=").concat(hash);

        Map<String,String> datamodel= new HashMap<String,String>();
        datamodel.put("responseURL",responseURL);
        datamodel.put("commonURL",commonURL);
        datamodel.put("login",login);

        return generateMessage("resetUserPasswordMail.ftl", datamodel);

    }

    /**
     * {@method createActivationMessage(String hash, String login)}
     *
     * @param hash (String of a hash, unique hash code used for generate URL)
     * @param login (object of an AccountUser.login, login name of user, used for generate message)
     * @return String message
     */

    public String createActivationMessage(String hash, String login) throws NotificationException {

        String commonURL = getRequestBaseURL();
        String responseURL = commonURL.concat(ACTIVATION_URL + "?hash=").concat(hash);

        Map<String,String> datamodel= new HashMap<String,String>();
        datamodel.put("responseURL",responseURL);
        datamodel.put("commonURL",commonURL);
        datamodel.put("login",login);

        return generateMessage("activationAccountMail.ftl", datamodel);

    }



}
