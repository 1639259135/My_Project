package com.lanou.springbootwyj.domain;

import java.io.Serializable;

public class Article implements Serializable {
    public static final  int PAGE_SIZE=6;
    private int goods_id;
    private String goods_name;
    private String goods_code;
    private int goods_count;
    private String file_id;
    private String sponsor;
    private String memo;
    private int dekete_flag;
    private int price;
    private String discount;
    private int type;

    public Article() {
    }

    public Article(int goods_id, String goods_name, String goods_code, int goods_count, String file_id, String sponsor, String memo, int dekete_flag, int price, String discount, int type) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_code = goods_code;
        this.goods_count = goods_count;
        this.file_id = file_id;
        this.sponsor = sponsor;
        this.memo = memo;
        this.dekete_flag = dekete_flag;
        this.price = price;
        this.discount = discount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Article{" + "goods_id=" + goods_id + ", goods_name='" + goods_name + '\'' + ", goods_code='" + goods_code + '\'' + ", goods_count=" + goods_count + ", file_id='" + file_id + '\'' + ", sponsor='" + sponsor + '\'' + ", memo='" + memo + '\'' + ", dekete_flag=" + dekete_flag + ", price=" + price + ", discount='" + discount + '\'' + ", type=" + type + '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public int getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getDekete_flag() {
        return dekete_flag;
    }

    public void setDekete_flag(int dekete_flag) {
        this.dekete_flag = dekete_flag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
