package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Class  {@code LoginController} creates login
 * freemarker pages
 *
 * @author Elena.
 * date: January 24, 2013
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("loginForm");
    }

    @RequestMapping(value = "/login-error")
    public ModelAndView loginError(){
        return new ModelAndView("loginForm");
    }

}
