package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class  {@code MenuPageController} creates for mapped "Menu" view
 * @DATE July 25, 2012
 * @author Ivan.
 */

@Controller
public class MenuPageController {
    /**
     * {@method index()} using for mapped "Menu" page view
     *
     * @return empty view name "Menu"
     */
    @RequestMapping(value = {"/menu"})
    public String menuPage() {

        return "Menu";
    }
}
