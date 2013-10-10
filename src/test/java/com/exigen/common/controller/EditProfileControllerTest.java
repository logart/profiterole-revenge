package com.exigen.common.controller;

import com.exigen.common.domain.AccountData;
import com.exigen.common.domain.AccountUser;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.EditProfileValidator;
import com.exigen.common.web.EditProfileController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: A. Kondratiev
 * Date: 22.03.13
 * Using for testing EditProfileController
 */
public class EditProfileControllerTest {
    @Mock
    private AccountService accountService ;

    @Mock
    private EditProfileValidator editProfileValidator;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEditingProfile() throws Exception {
        User user = new User("test","pass", AuthorityUtils.createAuthorityList("ROLE_USER"));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountUser accountUser = new AccountUser("test","pass","12345678");
        AccountData data =new AccountData();
        when(accountService.findByUsername("test")).thenReturn(accountUser);
        when(accountService.accountDataFromAccount(accountUser)).thenReturn(data);
        EditProfileController profile = new EditProfileController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        Map model=new TreeMap();
        Assert.assertNotNull(profile.editingProfile(model));
        Assert.assertEquals("editProfile", profile.editingProfile(model) );
    }

    @Test
    public void testProcessEditingProfileValidatedOk(){
        EditProfileController profile = new  EditProfileController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        ReflectionTestUtils.setField(profile,"editProfileValidator",this.editProfileValidator);

        Map model = new TreeMap();
        AccountData accountData= new AccountData() ;
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        when(editProfileValidator.supports(accountData.getClass())).thenReturn(true);

        Assert.assertEquals("redirect:profile", profile.processEditingProfile(model,accountData,result));
        verify(this.accountService).updateAccount((AccountData)anyObject());
    }

    @Test
    public void testProcessEditingProfileValidatedNotOk(){
        EditProfileController profile = new  EditProfileController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        ReflectionTestUtils.setField(profile,"editProfileValidator",this.editProfileValidator);

        Map model = new TreeMap();
        AccountData accountData= new AccountData() ;
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        when(editProfileValidator.supports(accountData.getClass())).thenReturn(true);

        Assert.assertNotNull(profile.processEditingProfile(model,accountData,result));
        Assert.assertEquals("editProfile", profile.processEditingProfile(model,accountData,result));

    }
}
