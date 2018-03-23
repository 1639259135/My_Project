package com.lanou.springbootwyj.domain;

import java.util.List;

public class CommentWrap {

    private int dtatus;
    private String message;

    private List<Comment> comments;

    public CommentWrap() {
    }

    public CommentWrap(int dtatus, String message, List<Comment> comments) {
        this.dtatus = dtatus;
        this.message = message;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CommentWrap{" + "dtatus=" + dtatus + ", message='" + message + '\'' + ", comments=" + comments + '}';
    }

    public int getDtatus() {
        return dtatus;
    }

    public void setDtatus(int dtatus) {
        this.dtatus = dtatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
