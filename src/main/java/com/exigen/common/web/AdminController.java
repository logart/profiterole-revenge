package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code AdminController} creates admin pages
 * @author Victoria Ganzha
 * @date 05.09.13
 *
 */

@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

}
