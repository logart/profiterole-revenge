package com.exigen.common.web;

import com.exigen.common.domain.Account;
import com.exigen.common.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Class  {@code RegistrationSuccessController} creates for mapped "registrationSuccess" view
 *
 * @author Oleg Kalinichenko.
 * @DATE February 16, 2013
 */
@Controller
@RequestMapping("/registrationSuccess")
public class RegistrationSuccessController {
    /**
     * {@code accountService} Contains implementation of AccountService interface
     */
    @Autowired
    private AccountService accountService;

    /**
     * {@method registrationSuccess()} using for mapped added account
     *
     * @return information about added account if account exist,
     *         else redirect to main page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registrationSuccess(Map model, @RequestParam("user") String user) {
        Account account = accountService.findByUsername(user);
        if (account != null) {
            model.put("user", account.getLogin());
        } else {
            return "redirect:";
        }
        return "registrationSuccess";
    }
}
