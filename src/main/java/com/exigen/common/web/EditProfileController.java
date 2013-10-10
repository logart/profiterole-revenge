package com.exigen.common.web;


import com.exigen.common.domain.AccountData;
import com.exigen.common.domain.AccountUser;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.EditProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Class  {@code EditProfileController} creates for mapped editProfile form
 *
 * @author A.Kondratiev
 * @DATE Mar 15, 2013
 */
@Controller

@RequestMapping("/editProfile")
public class EditProfileController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private EditProfileValidator editProfileValidator;

    private static final String MASK_PASSWORD = "**********";
    /**
     * {@method index()} using for mapped editProfile form
     *
     * @return editProfile form view name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String editingProfile(Map model) {
        AccountUser accountUser = accountService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        AccountData data = accountService.accountDataFromAccount(accountUser);
        data.setPassword(MASK_PASSWORD);
        model.put("editProfileData", data);
        return "editProfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processEditingProfile(Map model, @ModelAttribute("editProfileData") @Valid AccountData data, BindingResult errors) {
        ValidationUtils.invokeValidator(editProfileValidator, data, errors);
        if (errors.hasErrors()) {
            model.put("editProfileData", data);
            return "editProfile";
        }
        accountService.updateAccount(data);
        return "redirect:profile";
    }

}
