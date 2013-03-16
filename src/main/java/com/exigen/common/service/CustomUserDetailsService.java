package com.exigen.common.service;

import com.exigen.common.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    public UserDetails loadUserByUsername(String username) {
        Account account = accountService.findByUsername(username);
        if (account != null) {
            return new User(account.getLogin(), account.getPassword(), Collections.singleton(createAuthority(account)));
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    private GrantedAuthority createAuthority(Account account) {
        return new SimpleGrantedAuthority(account.getRole());
    }
}
