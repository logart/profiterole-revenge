package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 10.12.12
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = {"/success"})
public class SuccessController {
    @RequestMapping(method = RequestMethod.GET)
    public String showSuccess() {
        return "successAddedRecipe";
    }
}
