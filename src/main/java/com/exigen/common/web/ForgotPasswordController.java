package com.exigen.common.web;

import com.exigen.common.service.ForgotPasswordValidator;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.ServiceException;
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
 * Class  {@code ForgotPasswordController} creates fot forgot password form
 * @author  Victoria Ganzha
 * Date: 28.03.13
 */

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
    /**
     * {@code accountService} describes the AccountService to inject on this
     * class
     */
    @Autowired
    private AccountService accountService;
    /**
     * {@code forgotPasswordValidator} describes the ForgotPasswordValidator to inject on this
     * class
     */
    @Autowired
    private ForgotPasswordValidator forgotPasswordValidator;

    /**
     *
     * @param  "email"
     */

    @RequestMapping (method = RequestMethod.GET)
    public String forgotPassword(Map model){
        model.put("email", "");
        return  "forgotPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String forgotPassword(Map model, @ModelAttribute("email") @Valid String email, BindingResult errors) {
        ValidationUtils.invokeValidator(forgotPasswordValidator, email, errors);
        if (errors.hasErrors()){
            model.put("Errors", errors);
            return "forgotPassword";
        }
        try {
            accountService.resetUserPassword(email);
        } catch(ServiceException ex){
            return "redirect:";  }

        return "successSendMail";

    }

}
