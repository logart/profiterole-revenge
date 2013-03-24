package com.exigen.common.controller;
import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import com.exigen.common.service.AccountService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import com.exigen.common.web.ProfileController;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.*;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: Victoria Ganzha
 * Date: 21.03.13
 * Using for testing Profile Controller
 */
public class ProfileControllerTest {
    @Mock
    private AccountService accountService;

    Calendar calendar = new GregorianCalendar(2010, 11, 03);

    Account account = new Account("log", "pwd", "ololo@gmailcom", Gender.Female, calendar, "Ukraine");

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        User user = new User(account.getLogin(), account.getPassword(), Collections.singleton(new SimpleGrantedAuthority(account.getRole())));
        TestingAuthenticationToken authToken = new TestingAuthenticationToken(user, account.getPassword());
        authToken.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    @Test
    public void viewProfileController() throws Exception {
        when(accountService.findByUsername("log")).thenReturn(account);
        ProfileController profile = new  ProfileController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        Map model = new HashMap<String,String>();
        Assert.assertEquals("profile", profile.viewProfile(model));
        Assert.assertNotNull(model.get("account"));
    }



}
