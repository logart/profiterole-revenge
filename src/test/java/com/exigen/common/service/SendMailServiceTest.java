package com.exigen.common.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

public class SendMailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private SimpleMailMessage simpleMailMessage;

    @Mock
    private HttpServletRequest request;

    @Mock
    private Configuration cfg;

    @Mock
    private Template temp;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendMailTest(){
        SendMailService sendMailService = new SendMailServiceImpl();

        MockHttpSession mockHttpSession = new MockHttpSession();

        ReflectionTestUtils.setField(sendMailService, "request", request);
        ReflectionTestUtils.setField(sendMailService, "mailSender", mailSender);
        ReflectionTestUtils.setField(sendMailService, "simpleMailMessage", simpleMailMessage);
        ReflectionTestUtils.setField(sendMailService, "cfg",cfg);
        ReflectionTestUtils.setField(sendMailService, "temp", temp);

        when (request.getRequestURL()).thenReturn(new StringBuffer("http://our-test.cloudfoundry.com/forgotPassword"));
        when(request.getSession()).thenReturn(mockHttpSession);

        try {
            when (cfg.getTemplate(anyString())).thenThrow(new IOException());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendMailService.sendMail("123456789", "User", "user@user.com");
        verify(mailSender, never()).send((MimeMessage) anyObject());
    }

}
