package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * Class  {@code AboutController} creates about page
 * @author Elena
 * Date: 04.02.13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class AboutController {
    /**
     * {@method about()} using for mapped view
     *
     * @return  view name
     */
        @RequestMapping(value = "/about")
        public ModelAndView about(){
            return new ModelAndView("about");
        }
}
