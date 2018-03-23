package com.lanou.netctoss.roleinfo.web.controller;

import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import com.lanou.netctoss.roleinfo.domain.RoleInfoPage;
import com.lanou.netctoss.roleinfo.service.RoleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@RequestMapping(value = "/role")
@Controller
public class RoleInfoController {

    @Resource
    private RoleInfoService roleInfoService;

    @RequestMapping(value = "/showRole")
    public String showRole(RoleInfoPage page, Model model){
        RoleInfoPage p = roleInfoService.findRoleByLimit(page);
        model.addAttribute("roleInfoPage",p);
        return "role/role_list";
    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "role/role_add";
    }

    @RequestMapping(value = "/addRole")
    public String addRole(RoleInfo roleInfo, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        roleInfoService.addRole(roleInfo);
        return "redirect:showRole";
    }

    @RequestMapping(value = "/toModi")
    public String toModiRole(int id, Model model){
        RoleInfo roleById = roleInfoService.findRoleById(id);
        model.addAttribute("roleById",roleById);
        return "role/role_modi";
    }

    @RequestMapping(value = "/modiRole")
    public String modiRole(RoleInfo roleInfo,RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        roleInfoService.updateRole(roleInfo);
        return "redirect:showRole";
    }

    @RequestMapping(value = "/deleteRole")
    public String deleteRole(RoleInfo roleInfo, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        roleInfoService.deleteRole(roleInfo);
        return "redirect:showRole";
    }


}
