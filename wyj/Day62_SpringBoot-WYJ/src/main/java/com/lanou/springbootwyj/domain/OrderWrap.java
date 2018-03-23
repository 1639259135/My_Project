package com.lanou.springbootwyj.domain;

import java.util.List;

public class OrderWrap {

    private int status;
    private String message;

    private List<Order> orders;

    public OrderWrap() {
    }

    public OrderWrap(int status, String message, List<Order> orders) {
        this.status = status;
        this.message = message;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderWrap{" + "status=" + status + ", message='" + message + '\'' + ", orders=" + orders + '}';
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
