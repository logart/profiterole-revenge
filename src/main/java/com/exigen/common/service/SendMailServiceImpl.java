package com.exigen.common.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class {@code SendMailServiceImpl}  used for send mail massage
 *
 * @author Elena Vasilkovich
 * @date April 5,2013
 *
 */

@Service
public class SendMailServiceImpl implements SendMailService{

    protected static final Logger LOG = Logger.getLogger(SendMailServiceImpl.class.getName());

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
     * {@method sendMail(String message, String email)}
     * for send mail message
     *
     * @param message (Object message  generate by NotificationService, for send specific mail massage)
     * @param email (object of the Account.email, for send mail message on specific email)
     *
     */
    public void sendMail(String message,  String email) throws NotificationException {

        try {

            MimeMessage message1 = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message1, true);
            helper.setFrom(simpleMailMessage.getFrom());
            helper.setTo(email);
            helper.setSubject(simpleMailMessage.getSubject());
            helper.setText(message, true);
            mailSender.send(message1);
        }

        catch (MessagingException e) {
            LOG.log(Level.WARNING, "MessagingException in MimeMessageHelper", e);
            throw new NotificationException(e);
        }

    }

}
