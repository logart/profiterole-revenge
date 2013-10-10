package com.exigen.common.web;

import com.exigen.common.domain.AccountUser;
import com.exigen.common.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 14.02.13
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AllAccountsController{
    @Autowired
    private AccountService accountService;
    /**
     * {@method allOfRecipes()} using for load all cuisines to the page
     *
     * @return all cuisines list
     */
    @RequestMapping(value = {"/accounts"})
    public ModelAndView allAccounts() {
        List<AccountUser> accountUsers =  accountService.getAllAccounts();
        List<String> accountsText = new ArrayList<String>();
        for (AccountUser accountUser : accountUsers){
             accountsText.add(accountUser.getId() + ":  " + accountUser.getLogin() + ", "+ accountUser.getPassword());
        }
        return new ModelAndView("allAccounts", "accountUsers", accountsText);
    }
}
