package com.exigen.common.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



/**
 * Class {@code SendMailService}  used for send mail massage
 *
 * @author Elena Vasilkovich
 * @date April 5,2013
 *
 */
@Service("sendMailService")
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String hash, String login, String email) {

        SimpleMailMessage message1 = new SimpleMailMessage(simpleMailMessage);
        message1.setText(String.format(simpleMailMessage.getText(),login, hash ));
        message1.setTo(email);

        mailSender.send(message1);



        }


}
