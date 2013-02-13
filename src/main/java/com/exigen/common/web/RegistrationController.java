package com.exigen.common.web;


import com.exigen.common.domain.AddRecipeData;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Class  {@code RegistrationController} creates for mapped registration form
 *
 * @author v.samokhval.
 * @DATE January 22, 2013
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /**
     * {@method index()} using for mapped registration form
     *
     * @return registration form view name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registration(Map model) {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingUser(Map model, @ModelAttribute("registrationData") @Valid AddRecipeData data, BindingResult errors) {

        return "registration";
    }
}
