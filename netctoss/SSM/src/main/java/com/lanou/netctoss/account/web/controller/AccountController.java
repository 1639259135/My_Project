package com.lanou.netctoss.account.web.controller;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.account.domain.AccountPage;
import com.lanou.netctoss.account.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/showAccount")
    public String showAccount(AccountPage page, Model model){
        AccountPage p = accountService.findByLimit(page);
        model.addAttribute("accountPage",p);
        return "account/account_list";
    }

    @RequestMapping(value = "/toModi")
    public String toModi(int id, Model model){
        AccountExt account = accountService.findByAccountId(id);
        model.addAttribute("accountById",account);
        return "account/account_modi";
    }

    @RequestMapping(value = "/modiAccount")
    public String modiAccount(AccountExt account, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        accountService.updateAccount(account);
        return "redirect:showAccount";
    }

    @RequestMapping(value = "/toAdd")
    public String toAddAccount(){
        return "account/account_add";
    }

    @RequestMapping(value = "/addAccount")
    public String addAccount(AccountExt account, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        accountService.addAccount(account);
        return "redirect:showAccount";
    }

    @RequestMapping(value = "/deleteAccount")
    public String deleteAccount(AccountExt account, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        accountService.deleteAccount(account);
        return "redirect:showAccount";
    }

    @RequestMapping(value = "/oocAccount")
    public String openOrCloseAccount(AccountExt account, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        accountService.openOrCloseAccount(account);
        return "redirect:showAccount";
    }

    @RequestMapping(value = "accountDetail")
    public String accountDetail(int id, Model model){
        AccountExt a = accountService.findByAccountId(id);
        model.addAttribute("accountDetail",a);
        return "account/account_detail";
    }


}
