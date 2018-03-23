package com.lanou.springbootwyj.controller;

import com.lanou.springbootwyj.domain.Order;
import com.lanou.springbootwyj.domain.OrderWrap;
import com.lanou.springbootwyj.service.WyjService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private WyjService wyjService;


    @RequestMapping("/insertOrder")
    public OrderWrap insertOrder(Order order){
        boolean b = wyjService.insertOrder(order);
        if (b){
            return new OrderWrap(200,"添加成功",null);
        }
        return new OrderWrap(200,"添加失败",null);
    }

    @RequestMapping("/selectOrderByUid")
    public OrderWrap selectOrderByUid(int uid){
        List<Order> orders = wyjService.selectOrderByUid(uid);
        return new OrderWrap(200,"",orders);
    }

    @RequestMapping("/remove")
    public OrderWrap remove(int oid){
        boolean b = wyjService.remove(oid);
        if (b){
            return new OrderWrap(200,"删除成功",null);
        }
        return new OrderWrap(200,"删除失败",null);
    }

    @RequestMapping("/updataOrder")
    public OrderWrap updataOrder(int oid,int count){
        boolean b = wyjService.updataOrder(oid, count);
        if (b){
            return new OrderWrap(200,"更新成功",null);
        }
        return new OrderWrap(200,"更新失败",null);
    }




}
