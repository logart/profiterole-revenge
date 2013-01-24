package com.exigen.common.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class  {@code FillDbController} creates for mapped registration form
 *
 * @author v.samokhval.
 * @DATE January 22, 2013
 */
@Controller
public class RegistrationController {

    /**
     * {@method index()} using for mapped registration form
     *
     * @return registration form view name
     */
    @RequestMapping(value = {"/registration"})
    public String registration() {
        return "registration";
    }
}
