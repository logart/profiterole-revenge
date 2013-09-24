package com.exigen.common.web;

import com.exigen.common.domain.RoleConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class  {@code AccessDeniedController} is used to handle
 *  requests about 403 exception, when ROLE_INACTIVE_USER(user without activation) try to go on pages:
 *  /addRecipes, /editProfile, /profile and "forward" to the specified error page view.
 *
 * @autor Victoria Ganzha
 * @Date 05.06.13
 *
 */

@Controller
@RequestMapping("/noaccess")
public class AccessDeniedController {

    @RequestMapping
    public String accessDenied(Authentication authentication, Model model){
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(RoleConstants.ROLE_INACTIVE_USER))){
            model.addAttribute("user", authentication.getName());
            return "activationAccountNotFinished";

        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(RoleConstants.ROLE_USER))){
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
