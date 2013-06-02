package com.exigen.common.web;


import com.exigen.common.domain.ChangeForgottenPasswordData;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.ForgotPasswordChangingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * Class  {@code ForgottenPasswordChangingController} for changeForgottenPassword form
 * User: Anatolii Kondratiev
 * Date: 03.04.13
 * Time: 0:35
 *
 */

@Controller
@RequestMapping("/changeForgottenPassword")
public class ForgottenPasswordChangingController {

    /**
     * {@code forgotPasswordChangingValidator} describes the ForgotPasswordChangingValidator to inject on this
     * class
     */
    @Autowired
    private ForgotPasswordChangingValidator forgotPasswordChangingValidator ;

    /**
     * {@code accountService} describes the AccountService to inject on this
     * class
     */
    @Autowired
    private AccountService accountService;



    /**
     * shows changeForgottenPassword form
     * @param  "hash"
     */
    @RequestMapping(method = RequestMethod.GET)
    public String checkHashAndAskNewPassword(Map model, @RequestParam("hash") String hash) {
        ChangeForgottenPasswordData passwordData = new ChangeForgottenPasswordData() ;

        boolean check=accountService.checkAccountPasswordResetHash(hash);
        if (check){
            model.put("changeForgottenPasswordData", passwordData);
            return "changeForgottenPassword";
        }
        else {
            return "redirect:changeForgottenPassword/fail";
        }
    }

    /**
     * processing changeForgottenPassword form. validating user input and redirect to result page
     * @param  "ChangeForgottenPasswordData"
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processEditingProfile(Map model, @ModelAttribute("changeForgottenPasswordData") @Valid ChangeForgottenPasswordData passwordData, BindingResult errors) {
        ValidationUtils.invokeValidator(forgotPasswordChangingValidator, passwordData, errors);
        if (errors.hasErrors()) {
            model.put("password", passwordData);
            return "changeForgottenPassword";
        }
        try{
            accountService.changeForgottenUserPassword(passwordData.getHash(), passwordData.getPassword());
            return "redirect:changeForgottenPassword/success";
        }catch(Exception e){
            return "redirect:changeForgottenPassword/fail";
        }
    }

    /**
     * show success result page
     */
    @RequestMapping("/success")
    public String changeForgottenPasswordSuccess(Map model) {
        return "changeForgottenPasswordSuccess";
    }

    /**
     * show fail result page
     */
    @RequestMapping("/fail")
    public String changeForgottenPasswordFail(Map model) {
        return "changeForgottenPasswordFail";
    }

}
