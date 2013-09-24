package com.exigen.common.web;


import com.exigen.common.domain.AccountUser;
import com.exigen.common.domain.RoleConstants;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.NotificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Class  {@code HelloController} creates for mapped empty view
 * and for sending repeatedly message activation of account, then redirect to result page
 * @author Ivan.
 * @DATE July 25, 2012
 */
@Controller
public class HelloController {

    @Autowired
    private AccountService accountService;

    /**
     * {@method index()} using for mapped empty view
     * and for sending repeatedly message activation of account, then redirect to result page
     *
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities() != null &&
                authentication.getAuthorities().contains(new SimpleGrantedAuthority(RoleConstants.ROLE_INACTIVE_USER))){
            AccountUser accountUser = accountService.findByUsername(((User)authentication.getPrincipal()).getUsername());
            ModelAndView modelAndView =  new ModelAndView("registrationSuccess");
            try {
                modelAndView.addObject("user", accountUser.getLogin());
                accountService.activationHashSendMail(accountUser.getEmail());
            } catch (NotificationException e) {
                modelAndView.addObject("error", "Сервис временно не доступен!");
            }
            return modelAndView;
        }
        if (authentication != null && authentication.getAuthorities() != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority(RoleConstants.ROLE_ADMIN))){
            return new ModelAndView ("admin");
        }
        return new ModelAndView("MainPage");
    }
}