package com.exigen.common.web;


import com.exigen.common.domain.Account;
import com.exigen.common.domain.AccountData;
import com.exigen.common.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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
    /**
     * {@method index()} using for mapped registration form
     *
     * @return registration form view name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registration(Map model) {
        Account account =  accountService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        AccountData data = new AccountData();
        if (account != null) {
            data.setLogin(account.getLogin());
            data.setEmail(account.getEmail());
            data.setPassword(account.getPassword());
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            data.setDateOfBirth(sdf.format(account.getDateOfBirth().getTime()));
            data.setMaleOrFemale(account.getMaleOrFemale().name()) ;
            data.setCountry(account.getCountry());

            model.put("editProfileData", data);
        } else {
            return "redirect:";
        }
        return "editProfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddingUser(Map model, @ModelAttribute("editProfileData") @Valid AccountData data, BindingResult errors) {
        if (errors.hasErrors()) {
            model.put("editProfileData", data);
            return "editProfile";
        }

        accountService.updateAccount(data);

        return "redirect:profile";
    }

}
