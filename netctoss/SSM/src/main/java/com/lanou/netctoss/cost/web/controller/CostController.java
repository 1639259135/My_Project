package com.lanou.netctoss.cost.web.controller;

import com.lanou.netctoss.base.Page;
import com.lanou.netctoss.cost.domain.Cost;
import com.lanou.netctoss.cost.domain.CostPage;
import com.lanou.netctoss.cost.service.CostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/cost")
public class CostController {

    @Resource
    private CostService costService;

    @RequestMapping(value = "/showCost")
    public String findAllCosts(CostPage page, Model model){
        CostPage p = costService.findCost(page);
        model.addAttribute("costPage",p);
        return "fee/fee_list";
    }

    @RequestMapping(value = "toAdd")
    public String toAdd(){
        return "fee/fee_add";
    }

    @RequestMapping(value = "/add")
    public String addCost(Cost cost, RedirectAttributes ra){
        String s = costService.addCost(cost);
        if (s == null){
            return "fee/fee_add";
        }
        ra.addAttribute("pageCode",1);
        return "redirect:showCost";
    }

    @RequestMapping(value = "/toModi")
    public String toModi(int id,Model model){
        Cost cost = costService.findById(id);
        model.addAttribute("costById",cost);
        return "fee/fee_modi";
    }

    @RequestMapping(value = "/update")
    public String update(Cost cost, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        costService.updateCost(cost);
        return "redirect:showCost";
    }

    @RequestMapping(value = "/delete")
    public String delete(int id, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        costService.deleteCost(id);
        return "redirect:showCost";
    }

    @RequestMapping(value = "/open")
    public String open(Cost cost, RedirectAttributes ra){
        ra.addAttribute("pageCode",1);
        costService.updateCost(cost);
        return "redirect:showCost";
    }

    @RequestMapping(value = "/showDetail")
    public String showDetail(int id, Model model){
        Cost c = costService.findById(id);
        model.addAttribute("costDetail",c);
        return "fee/fee_detail";
    }

}
