package com.lanou.springbootwyj.controller;

import com.lanou.springbootwyj.domain.Comment;
import com.lanou.springbootwyj.domain.CommentWrap;
import com.lanou.springbootwyj.service.WyjService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class CommentController {

    @Resource
    private WyjService wyjService;

    @RequestMapping("/selectCommentById")
    public CommentWrap selectCommentById(int id){
        List<Comment> comments = wyjService.selectCommentById(id);
        System.out.println(Arrays.toString(comments.toArray()));
        return new CommentWrap(200,"",comments);
    }



}
