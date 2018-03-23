package com.lanou.springbootwyj.controller;

import com.lanou.springbootwyj.domain.User;
import com.lanou.springbootwyj.domain.UserWrap;
import com.lanou.springbootwyj.service.WyjService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private WyjService wyjService;

    @RequestMapping("/isExit")
    public UserWrap isExit(User user){
        User userByPhone = wyjService.findUserByPhone(user.getPhone());
        if (userByPhone == null){
            return new UserWrap(200,"",new User());
        }
        return new UserWrap(200,"",userByPhone);
    }

    @RequestMapping("/selectUser")
    public UserWrap selectUser(User user){
        User u = wyjService.selectUser(user);
        if (u == null){
            return new UserWrap(200,"",new User());
        }
        return new UserWrap(200,"",u);
    }

    @RequestMapping("/insertUser")
    public UserWrap register(User user){
        wyjService.register(user);
        return new UserWrap(200,"",new User());
    }

    @RequestMapping("/selectUserByLogin")
    public UserWrap login(User user){
        User u = wyjService.selectUserByLogin(user);
        return new UserWrap(200,"",u);
    }


}
