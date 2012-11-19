package com.exigen.common.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code FillDbController} creates for mapped empty view
 *
 * @author Ivan.
 * @DATE July 25, 2012
 */
@Controller
public class HelloController {

    /**
     * {@method index()} using for mapped empty view
     *
     * @return empty view name
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("MainPage");
    }
}