package com.lanou.springbootwyj.domain;

public class User {
  private Long user_id;
  private String user_name;
  private String password;
  private String real_name;
  private Long sex;
  private String phone;
  private String id_card;
  private String address;
  private Long user_type;
  private Long delete_flag;
  private String email;
  private String emailpw;
  private Long prepare1;
  private String prepare2;
  private String prepare3;

  public User() {
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getReal_name() {
    return real_name;
  }

  public void setReal_name(String real_name) {
    this.real_name = real_name;
  }

  public Long getSex() {
    return sex;
  }

  public void setSex(Long sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getId_card() {
    return id_card;
  }

  public void setId_card(String id_card) {
    this.id_card = id_card;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getUser_type() {
    return user_type;
  }

  public void setUser_type(Long user_type) {
    this.user_type = user_type;
  }

  public Long getDelete_flag() {
    return delete_flag;
  }

  public void setDelete_flag(Long delete_flag) {
    this.delete_flag = delete_flag;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailpw() {
    return emailpw;
  }

  public void setEmailpw(String emailpw) {
    this.emailpw = emailpw;
  }

  public Long getPrepare1() {
    return prepare1;
  }

  public void setPrepare1(Long prepare1) {
    this.prepare1 = prepare1;
  }

  public String getPrepare2() {
    return prepare2;
  }

  public void setPrepare2(String prepare2) {
    this.prepare2 = prepare2;
  }

  public String getPrepare3() {
    return prepare3;
  }

  public void setPrepare3(String prepare3) {
    this.prepare3 = prepare3;
  }

  @Override
  public String toString() {
    return "User{" +
            "user_id=" + user_id +
            ", user_name='" + user_name + '\'' +
            ", password='" + password + '\'' +
            ", real_name='" + real_name + '\'' +
            ", sex=" + sex +
            ", phone='" + phone + '\'' +
            ", id_card='" + id_card + '\'' +
            ", address='" + address + '\'' +
            ", user_type=" + user_type +
            ", delete_flag=" + delete_flag +
            ", email='" + email + '\'' +
            ", emailpw='" + emailpw + '\'' +
            ", prepare1=" + prepare1 +
            ", prepare2='" + prepare2 + '\'' +
            ", prepare3='" + prepare3 + '\'' +
            '}';
  }
}
