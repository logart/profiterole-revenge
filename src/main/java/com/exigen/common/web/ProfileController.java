package com.exigen.common.web;

import com.exigen.common.domain.AccountUser;
import com.exigen.common.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * Class  {@code ProfileController} is used to handle
 *  requests for profile information view
 * @autor Victoria Ganzha
 * @Date 12.03.13
 *
 */

@Controller
@RequestMapping("/profile")
public class ProfileController{
    /**
     * {@code accountService} describes the AccountService to inject on this
     * class
     */
    @Autowired
    private AccountService accountService;
    /**
     * {@method viewProfile() for authentication user }
     *
     * @return  information about profile
     */

    @RequestMapping(method = RequestMethod.GET)
    public String viewProfile(Map model){
       String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        AccountUser accountUser =  accountService.findByUsername(userName);
        model.put("accountUser", accountUser);
        return "profile";
    }

}
