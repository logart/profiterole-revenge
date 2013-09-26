package com.exigen.common.service;

import com.exigen.common.domain.AbstractAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Class {@code CustomUserDetailsService} used for taking login what user input in the form,
 * and searching account with that login
 *
 * @author Oleg Kalinichenko
 * @date February 5,2013
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    public UserDetails loadUserByUsername(String username) {

        AbstractAccount abstractAccount =  accountService.findAccountByUserName(username);

        if (abstractAccount!= null) {
            return new User(abstractAccount.getLogin(),abstractAccount.getPassword(), Collections.singleton(createAuthority(abstractAccount)));

        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    private GrantedAuthority createAuthority(AbstractAccount abstractAccount) {
        return new SimpleGrantedAuthority(abstractAccount.getRole());
    }

    public void  login(String username,String password){
        Authentication token = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authentication =  authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
