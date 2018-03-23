package com.lanou.springbootwyj.domain;

public class Comment {
  private int comment_id;
  private int mark;
  private String content;
  private String comment_user;
  private String comment_time;
  private String store_id;
  private int tucao_mark;
  private String prepare1;
  private int delete_flag;

  public int getComment_id() {
    return comment_id;
  }

  public void setComment_id(int comment_id) {
    this.comment_id = comment_id;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getComment_user() {
    return comment_user;
  }

  public void setComment_user(String comment_user) {
    this.comment_user = comment_user;
  }

  public String getComment_time() {
    return comment_time;
  }

  public void setComment_time(String comment_time) {
    this.comment_time = comment_time;
  }

  public String getStore_id() {
    return store_id;
  }

  public void setStore_id(String store_id) {
    this.store_id = store_id;
  }

  public int getTucao_mark() {
    return tucao_mark;
  }

  public void setTucao_mark(int tucao_mark) {
    this.tucao_mark = tucao_mark;
  }

  public String getPrepare1() {
    return prepare1;
  }

  public void setPrepare1(String prepare1) {
    this.prepare1 = prepare1;
  }

  public int getDelete_flag() {
    return delete_flag;
  }

  public void setDelete_flag(int delete_flag) {
    this.delete_flag = delete_flag;
  }
}
