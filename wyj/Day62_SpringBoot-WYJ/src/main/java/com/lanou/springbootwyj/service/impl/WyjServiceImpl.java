package com.lanou.springbootwyj.service.impl;

import com.lanou.springbootwyj.domain.Article;
import com.lanou.springbootwyj.domain.Comment;
import com.lanou.springbootwyj.domain.Order;
import com.lanou.springbootwyj.mapper.ArticleMapper;
import com.lanou.springbootwyj.mapper.CommentMapper;
import com.lanou.springbootwyj.mapper.OrderMapper;
import com.lanou.springbootwyj.mapper.UserMapper;
import com.lanou.springbootwyj.domain.User;
import com.lanou.springbootwyj.service.WyjService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WyjServiceImpl implements WyjService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private OrderMapper orderMapper;


    @Override
    public User selectUserByLogin(User user) {
        return userMapper.selectUserByLogin(user);
    }

    @Override
    public  User selectUser(User user){
        return userMapper.selectUser(user);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public void   register(User user) {
        userMapper.insertUser(user);
    }



    public List<Article> findArticles(){
        return articleMapper.findArticles();
    }

    public List<Article> findArticleByHot(int page){
        return articleMapper.findArticleByHot((page-1)*Article.PAGE_SIZE,Article.PAGE_SIZE);
    }

    public List<Article> selectByType(String type){
        return articleMapper.selectByType(type);
    }

    public List<Article> selectById(int id){
        return articleMapper.selectById(id);
    }


    public List<Comment> selectCommentById(int id){
        return commentMapper.selectCommentById(id);
    }


    @Override
    public boolean insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    public List<Order> selectOrderByUid(int uid){
        return orderMapper.selectOrderByUid(uid);
    }

    public boolean remove(int oid){
        return orderMapper.remove(oid);
    }

    public boolean updataOrder(int oid,int count){
        return orderMapper.updataOrder(oid,count);
    }


}
