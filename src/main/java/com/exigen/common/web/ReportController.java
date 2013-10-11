package com.exigen.common.web;

import com.exigen.common.response.RecipeDto;
import com.exigen.common.response.SummaryDto;
import com.exigen.common.service.ReportCreatorService;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
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

    @RequestMapping(value = "/createRecipePdfReport")
    @ResponseBody
    public void createRecipePdfReport(HttpServletRequest request, HttpServletResponse response) {
        try {

            String jsonString = request.getReader().readLine();
            RecipeDto recipeDto = new Gson().fromJson(jsonString, RecipeDto.class);
            FileCopyUtils.copy(
                    convertOutputToInput(reportCreatorService.createReport("Recipe.jasper", recipeDto)),
                    response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/createMenuPdfReport")
    @ResponseBody
    public void createMenuPdfReport(HttpServletRequest request, HttpServletResponse response) {
        try {

            String jsonString = request.getReader().readLine();
            SummaryDto summaryDto = new Gson().fromJson(jsonString, SummaryDto.class);
            FileCopyUtils.copy(
                    convertOutputToInput(reportCreatorService.createReport("Recipe.jasper", summaryDto)),
                    response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream convertOutputToInput(OutputStream outputStream) {
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }
}
