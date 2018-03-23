package com.lanou.springbootwyj.service;

import com.lanou.springbootwyj.domain.Article;
import com.lanou.springbootwyj.domain.Comment;
import com.lanou.springbootwyj.domain.Order;
import com.lanou.springbootwyj.domain.User;

import java.util.List;

public interface WyjService {

    User selectUserByLogin(User user);
    User selectUser(User user);
    User findUserByPhone(String phone);
    void register(User user);


    List<Article> findArticles();
    List<Article> findArticleByHot(int page);
    List<Article> selectByType(String type);
    List<Article> selectById(int id);

    List<Comment> selectCommentById(int id);

    boolean insertOrder(Order order);
    List<Order> selectOrderByUid(int uid);
    boolean remove(int oid);
    boolean updataOrder(int oid,int count);


}
