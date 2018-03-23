package com.lanou.springbootwyj.domain;

import java.util.List;

public class ArticleWrap {

    private int status;
    private String message;

    private List<Article> articles;

    public ArticleWrap() {
    }

    public ArticleWrap(int status, String message, List<Article> articles) {
        this.status = status;
        this.message = message;
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleWrap{" + "status=" + status + ", message='" + message + '\'' + ", articles=" + articles + '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
