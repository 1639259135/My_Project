package com.lanou.springbootwyj.domain;

public class UserWrap {

    private int status;
    private String message;

    private User user;

    public UserWrap() {
    }

    public UserWrap(int status, String message, User user) {
        this.status = status;
        this.message = message;
        this.user = user;
    }

    @Override
    public String toString() {
        return "WrapBean{" + "status=" + status + ", message='" + message + '\'' + ", user=" + user + '}';
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
