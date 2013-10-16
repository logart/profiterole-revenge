package com.exigen.common.web;

import com.exigen.common.domain.Recipe;
import com.exigen.common.response.MenuDto;
import com.exigen.common.response.RecipeDto;
import com.exigen.common.service.RecipeService;
import com.exigen.common.service.ReportCreatorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 */
@Controller
public class ReportController {

    @Autowired
    private ReportCreatorService reportCreatorService;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = {"/pdf"})
    @ResponseBody
    public void pdfTest(@RequestParam("recipeId") Integer recipeId, HttpServletResponse response) throws Exception{
        Recipe recipe = recipeService.getOneRecipe(recipeId);
        reportCreatorService.createReport("recipe.jasper", recipe, response.getOutputStream());
    }

    @RequestMapping(value = "/menuPDF")
    public void createMenuPdfReport(HttpServletRequest request, HttpServletResponse response) {
        try {

            String jsonString = request.getReader().readLine();
            MenuDto menuDto = new Gson().fromJson(jsonString, MenuDto.class);
            reportCreatorService.createReport("menu.jasper", menuDto, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
