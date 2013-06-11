package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class  {@code MenuPageController} creates for mapped "Menu" view
 *
 * @author Ivan.
 * @DATE July 25, 2012
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

    /**
     * {@method index()} using for mapped "MenuForWeek" page view
     *
     * @return empty view name "MenuForWeek"
     */
    @RequestMapping(value = {"/menuForWeek"})
    public String menForWeekPage() {

        return "MenuForWeek";
    }
}
