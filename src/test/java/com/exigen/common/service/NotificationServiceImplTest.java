package com.exigen.common.service;

import freemarker.template.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class NotificationServiceImplTest {

    @Mock
    private HttpServletRequest request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void createResetPasswordMessageTest(){
        NotificationService notificationService = new NotificationServiceImpl();
        Configuration cfg = new Configuration();
        MockHttpSession mockHttpSession = new MockHttpSession();
        ReflectionTestUtils.setField(notificationService, "request", request);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://our-test.cloudfoundry.com/forgotPassword"));
        when(request.getSession()).thenReturn(mockHttpSession);

        try {
            when (cfg.getTemplate(anyString())).thenThrow(new IOException());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
