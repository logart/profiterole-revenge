package com.exigen.common.web;


import com.exigen.common.service.AccountService;
import com.exigen.common.domain.RegistrationData;
import com.exigen.common.service.NotificationException;
import com.exigen.common.service.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
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
    @Autowired
    private AccountService accountService;
    @Autowired
    private RegistrationValidator registrationValidator;


    /**
     * {@method registration(Map model)} using for mapped registration form
     *
     * @return registration form view name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registration(Map model) {
        RegistrationData data = new RegistrationData();
        model.put("registrationData", data);
        return "registration";
    }

    /**
     * {@method processAddingUser(Map model,  RegistrationData data, BindingResult errors)
     * for registration of user and redirect to result page
     *
     * @param data (object of RegistrationData)}
     **/
    @RequestMapping(method = RequestMethod.POST)
    public String processAddingUser(Map model, @ModelAttribute("registrationData") @Valid RegistrationData data, BindingResult errors) {
        ValidationUtils.invokeValidator(registrationValidator, data, errors);
        if (errors.hasErrors()) {
            model.put("registrationData", data);
            return "registration";
        }
        try {
            accountService.addAccount(data);
        }
        catch(NotificationException e){
            return "redirect:/login";
        }
        return "redirect:registrationSuccess?user=" + data.getLogin();
    }

}
