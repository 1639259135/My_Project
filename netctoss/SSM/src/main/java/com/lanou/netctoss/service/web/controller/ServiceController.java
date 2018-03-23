package com.lanou.netctoss.service.web.controller;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.service.domain.Service;
import com.lanou.netctoss.service.domain.ServicePage;
import com.lanou.netctoss.service.service.SService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@RequestMapping(value = "/service")
@Controller
public class ServiceController {

    @Resource
    private SService sService;

    @RequestMapping(value = "/showService")
    public String showService(ServicePage page, Model model){
        ServicePage p = sService.findServiceByPage(page);
        model.addAttribute("servicePage",p);
        return "service/service_list";
    }

    @RequestMapping(value = "/toAdd")
    public String toAddService(){
        return "service/service_add";
    }

    @RequestMapping(value = "/addService")
    public String addService(Service service, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        sService.insertService(service);
        return "redirect:showService";
    }

    @RequestMapping(value = "/accountByIdcard")
    public String findAccountByIdcard(String iscardNo, Model model){
        AccountExt account = sService.findAccountByIdcard(iscardNo);
        System.out.println(account);
        if (account == null){
            model.addAttribute("accountMsg","没有此身份证号，请重新录入。");
        }
        model.addAttribute("accountByIdcard",account);
        return "service/service_add";
    }

    @RequestMapping(value = "/delete")
    public String deleteService(Service service, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        sService.deleteService(service);
        return "redirect:showService";
    }

    @RequestMapping(value = "/openOrClose")
    public String openOrCloseService(Service service, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        sService.openOrCloseService(service);
        return "redirect:showService";
    }

    @RequestMapping(value = "/showDetail")
    public String toDetail(Service service, Model model){
        Service se = sService.findServiceById(service);
        model.addAttribute("serviceDetail",se);
        return "service/service_detail";
    }

}
