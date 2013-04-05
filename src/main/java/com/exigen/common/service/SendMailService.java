package com.exigen.common.service;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * Class {@code SendMailService}  used for send mail massage
 *
 * @author Elena Vasilkovich
 * @date April 5,2013
 *
 */
@Service("sendMailService")
public class SendMailService {
    /**
     * {@code mailSender} describes the JavaMailSender to inject on this
     * class
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * {@code simpleMailMessage} describes the SimpleMailMessage to inject on this
     * class
     */
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    /**
     * {@code request} describes the HttpServletRequest to inject on this
     * class
     */
    @Autowired
    private HttpServletRequest request;


    /**
     * {@method setSimpleMailMessage(SimpleMailMessage simpleMailMessage)}
     * Inject in this class
     */
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    /**
     * {@method setMailSender(JavaMailSender mailSender)}
     * Inject in this class
     *
     */
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    /**
     * {@method setRequest(HttpServletRequest request)}
     * Inject in this class
     *
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    /**
     * {@method sendMail(String hash, String login, String email)}
     * for send mail message
     *
     * @param hash (object of the hash)
     * @param login (object of the Account.login)
     * @param email (object of the Account.email)
     *
     */
    public void sendMail(String hash, String login, String email) {

        StringBuffer requestURL = request.getRequestURL();
        requestURL.delete(requestURL.lastIndexOf("forgotPassword"), requestURL.length());
        String commonURL = requestURL.toString();
        requestURL.append("changeForgottenPassword?hash=");
        requestURL.append(hash);
        String responseURL = requestURL.toString();

        Map<String,String> datamodel= new HashMap<String,String>();
        datamodel.put("responseURL",responseURL);
        datamodel.put("commonURL",commonURL);
        datamodel.put("login",login);

        Configuration   cfg = new Configuration();

        cfg.setServletContextForTemplateLoading(request.getSession().getServletContext(),"WEB-INF/freemarker");

        try {
            Template temp = cfg.getTemplate("mail.ftl");
            StringWriter writer = new StringWriter();
            temp.process(datamodel,writer);

            MimeMessage message1 = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message1, true);

            helper.setFrom(simpleMailMessage.getFrom());
            helper.setTo(email);
            helper.setSubject(simpleMailMessage.getSubject());
            helper.setText(writer.toString(),true);
            mailSender.send(message1);
        }
        catch (MessagingException e) {
            throw new MailParseException(e);
        }
        catch (TemplateException e ) {

        }
        catch (IOException e ) {

        }

    }

}
