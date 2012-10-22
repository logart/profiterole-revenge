package com.exigen.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeListController {
    @RequestMapping(value = "/recipeList")
    public String simple1() {
        return "recipeList";
    }
}