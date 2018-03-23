package com.lanou.netctoss.account.domain;

import java.util.Date;

public class AccountExt extends Account {

    private String recommenderIdcard;

    public AccountExt(Integer accountId, Integer recommenderId, String loginName, String status, Date createDate, Date pauseDate, Date closeDate, String realName, String idcardNo, Date birthdate, String gender, String occupation, String telephone, String email, String emailaddress, String zipcode, String qq, Date lastLoginTime, String lastLoginIp, String loginPasswd, Integer column21) {
        super(accountId, recommenderId, loginName, status, createDate, pauseDate, closeDate, realName, idcardNo, birthdate, gender, occupation, telephone, email, emailaddress, zipcode, qq, lastLoginTime, lastLoginIp, loginPasswd, column21);
    }

    public AccountExt() {
    }

    @Override
    public String toString() {
        return "AccountExt{" + "recommenderIdcard='" + recommenderIdcard + '\'' + '}';
    }

    public String getRecommenderIdcard() {
        return recommenderIdcard;
    }

    public void setRecommenderIdcard(String recommenderIdcard) {
        this.recommenderIdcard = recommenderIdcard;
    }
}
