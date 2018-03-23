package com.lanou.springbootwyj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class JumpConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toLogin").setViewName("/login");
        registry.addViewController("/toRegister").setViewName("/regest");
        registry.addViewController("/xzdp").setViewName("/xzdp");
        registry.addViewController("/fenlei").setViewName("/fenlei");
        registry.addViewController("/grzx").setViewName("/grzx");
        registry.addViewController("/dzwh").setViewName("/dzwh");
        registry.addViewController("/article").setViewName("/article");
        registry.addViewController("/xzdp").setViewName("/xzdp");
        registry.addViewController("/sqkd").setViewName("/sqkd");
        registry.addViewController("/fw").setViewName("/fw");
        registry.addViewController("/news").setViewName("/news");
        registry.addViewController("/gwc").setViewName("/gwc");
        registry.addViewController("/xzdp1").setViewName("/xzdp1");
        registry.addViewController("/pro_list").setViewName("/pro_list");
        registry.addViewController("/pro_detail").setViewName("/pro_detail");
        registry.addViewController("/pro_detailc_").setViewName("/pro_detailc_");
        registry.addViewController("/pro_pj").setViewName("/pro_pj");
        registry.addViewController("/dzwh").setViewName("/dzwh");
        registry.addViewController("/wddd").setViewName("/wddd");
        registry.addViewController("/dfh").setViewName("/dfh");
        registry.addViewController("/dsh").setViewName("/dsh");
        registry.addViewController("/dpj").setViewName("/dpj");
        registry.addViewController("/ywc").setViewName("/ywc");
        registry.addViewController("/yqx").setViewName("/yqx");
        registry.addViewController("/wdsc").setViewName("/wdsc");
        registry.addViewController("/").setViewName("/");
        registry.addViewController("/").setViewName("/");
    }

}
