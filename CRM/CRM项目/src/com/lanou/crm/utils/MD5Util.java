package com.lanou.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5(String str){
        try {
            //获得算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算函数
            md.update(str.getBytes());
            //digest方法确定最后返回的md5的hash值,返回值为8字符串
            //BigInteger方法将8位字符串转换为16位hash值,
            String s = new BigInteger(1, md.digest()).toString(16);
            return s;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
