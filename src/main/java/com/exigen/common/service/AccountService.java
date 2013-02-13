package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class {@code AccountService} used for push object from and in DAO for get and
 * add objects into DB with helps SpringTransaction and JPA
 *
 * @author Oleg Kalinichenko
 * @date February 5,2013
 */
@Service
public class AccountService {
    private Map<String, Account> accounts;

    public AccountService() {
        accounts = new HashMap<String, Account>();
        accounts.put("qwe", new Account("qwe", "qwe", "mail1@mail.com", Gender.Female, new GregorianCalendar()));
        accounts.put("1", new Account("1", "1", "mail2@mail.com", Gender.Female, new GregorianCalendar()));
    }

    public Account findByUsername(String username) {
        if (!accounts.containsKey(username)) {
            return null;
        }
        return accounts.get(username);
    }

}
