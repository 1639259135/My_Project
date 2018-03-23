package com.lanou.netctoss.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @RequestMapping(value = "/userInfo")
    public String toUserInfo(){
        return "user/user_info";
    }

    @RequestMapping(value = "/userModi")
    public String toUserModi(){
        return "user/user_modi_pwd";
    }

    @RequestMapping(value = "/bill")
    public String toBill(){
        return "bill/bill_list";
    }

    @RequestMapping(value = "/report")
    public String toReporet(){
        return "report/report_list";
    }


}
