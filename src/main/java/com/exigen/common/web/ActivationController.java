package com.exigen.common.web;

import com.exigen.common.domain.Account;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Class  {@code ActivationController} creates for mapped activation view
 *
 * @author Elena Vasilkovich
 * @DATE May 25, 2013
 */

@Controller
@RequestMapping("/activation")
public class ActivationController {
    /**
     * {@code accountService} describes the AccountService to inject on this
     * class
     */
    @Autowired
    private AccountService accountService;
    /**
     * {@code CustomUserDetailsService} describes the CustomUserDetailsService to inject on this
     * class
     */
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    /**
     * {@method checkHashAndActivate(Map model, String hash)}
     * for activation of account, authentication of user and  and redirect to result page
     *
     * @param hash (string with hash)
     **/
    @RequestMapping(method = RequestMethod.GET)
    public String checkHashAndActivate(Map model, @RequestParam("hash") String hash) {
            Account account =  accountService.activationOfAccount(hash);
            if (account!=null){
                customUserDetailsService.login(account.getLogin(),account.getPassword());
                model.put("user", account.getLogin());
                return "redirect:activation/success?user=";
            }
            else{
                 return "redirect:activation/fail";
            }
    }

    /**
     * show success result page
     */
    @RequestMapping("/success")
    public String activationSuccess(Map model,@RequestParam("user") String user) {
        model.put("user",user);
        return "activationSuccess";
    }

    /**
     * show fail result page
     */
    @RequestMapping("/fail")
    public String activationFail(Map model) {
        return "activationFail";
    }
}

