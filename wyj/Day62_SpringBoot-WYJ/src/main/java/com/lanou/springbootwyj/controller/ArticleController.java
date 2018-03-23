package com.lanou.springbootwyj.controller;

import com.lanou.springbootwyj.domain.Article;
import com.lanou.springbootwyj.domain.ArticleWrap;
import com.lanou.springbootwyj.service.WyjService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class ArticleController {

    @Resource
    private WyjService wyjService;


    @RequestMapping("/findArticles")
    public ArticleWrap findArticles(){
        List<Article> articles = wyjService.findArticles();
        return new ArticleWrap(200,"",articles);
    }

    @RequestMapping("/selectByHot")
    public ArticleWrap findArticleByHot(){
        List<Article> articleByHot = wyjService.findArticleByHot(2);
//        System.out.println(Arrays.toString(articleByHot.toArray()));
        return new ArticleWrap(200,"",articleByHot);
    }

    @RequestMapping("/selectByType")
    public ArticleWrap selectByType(String type){
        List<Article> articles = wyjService.selectByType(type);
//        System.out.println(Arrays.toString(articles.toArray()));
        return new ArticleWrap(200,"",articles);
    }

    @RequestMapping("/selectById")
    public ArticleWrap selectById(int id){
        System.out.println(id);
        List<Article> articles = wyjService.selectById(id);
//        System.out.println(Arrays.toString(articles.toArray()));
        return new ArticleWrap(200,"",articles);
    }

}
