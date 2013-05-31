package com.exigen.common.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;


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
        MockHttpSession mockHttpSession = new MockHttpSession();
        ReflectionTestUtils.setField(notificationService, "request", request);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://our-test.cloudfoundry.com/forgotPassword"));
        when(request.getSession()).thenReturn(mockHttpSession);
    }


}
