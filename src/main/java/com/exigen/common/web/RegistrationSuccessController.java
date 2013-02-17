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
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 16.02.13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/registrationSuccess")
public class RegistrationSuccessController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String registrationSuccess(Map model, @RequestParam("user") String user) {
        Account account = accountService.findByUsername(user);
        if(account != null){
            model.put("user", account.getLogin());
        }else{
            return "redirect:";
        }
        return "registrationSuccess";
    }
}
