package com.lanou.netctoss.admininfo.web.controller;

import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import com.lanou.netctoss.admininfo.domain.AdminInfoPage;
import com.lanou.netctoss.admininfo.service.AdminInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@RequestMapping(value = "/admin")
@Controller
public class AdminInfoController {

    @Resource
    private AdminInfoService adminInfoService;

    @RequestMapping(value = "/showAdmin")
    public String showAdmin(AdminInfoPage page, Model model){
        System.out.println(page.getPageCode());
        AdminInfoPage p = adminInfoService.findAdminByLimit(page);
        model.addAttribute("adminPage",p);
        return "admin/admin_list";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "admin/admin_add";
    }

    @RequestMapping(value = "/addAdmin")
    public String addAdmin(AdminInfoExt adminInfoExt, RedirectAttributes ra){
        adminInfoService.addAdmin(adminInfoExt);
        ra.addAttribute("pageCode",1);
        return "redirect:showAdmin";
    }

    @RequestMapping(value = "/toModi")
    public String toModiAdmin(AdminInfoPage page, Model model){
        AdminInfoExt adminInfoExt = adminInfoService.findAdminById(page);
        model.addAttribute("adminById",adminInfoExt);
        return "admin/admin_modi";
    }

    @RequestMapping(value = "modiAdmin")
    public String modiAdmin(AdminInfoExt adminInfoExt, RedirectAttributes ra){
        adminInfoService.modiAdmin(adminInfoExt);
        ra.addAttribute("pageCode",1);
        return "redirect:showAdmin";
    }

    @RequestMapping(value = "/deleteAdmin")
    public String deleteAdmin(AdminInfoPage page, RedirectAttributes ra){
        adminInfoService.deleteAdmin(page);
        ra.addAttribute("pageCode",1);
        return "redirect:showAdmin";
    }

    @RequestMapping(value = "/resetPwd")
    public String resetPwd(AdminInfoPage page, RedirectAttributes ra){
        adminInfoService.resetPwd(page);
        ra.addAttribute("pageCode",1);
        return "redirect:showAdmin";
    }

}
