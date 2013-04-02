package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * * Class  {@code RulesController} creates rules page
 * User: lena
 * Date: 01.02.13
 * Time: 17:00
 * @author Elena.
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RulesController {

        @RequestMapping(value = "/rules")
         public ModelAndView rules(){
            return new ModelAndView("rules");
        }
}
