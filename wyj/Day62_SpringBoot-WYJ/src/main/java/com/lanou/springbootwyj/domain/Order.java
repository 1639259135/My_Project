package com.lanou.springbootwyj.domain;

public class Order {
  private Long oid;
  private String aname;
  private String acount;
  private Long price;
  private Long uid;
  private String message;
  private Long count;

  public Order() {
  }

  public Order(Long oid, String aname, String acount, Long price, Long uid, String message, Long count) {
    this.oid = oid;
    this.aname = aname;
    this.acount = acount;
    this.price = price;
    this.uid = uid;
    this.message = message;
    this.count = count;
  }

  @Override
  public String toString() {
    return "Order{" + "oid=" + oid + ", aname='" + aname + '\'' + ", acount='" + acount + '\'' + ", price=" + price + ", uid=" + uid + ", message='" + message + '\'' + ", count=" + count + '}';
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }

  public String getAcount() {
    return acount;
  }

  public void setAcount(String acount) {
    this.acount = acount;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }
}
