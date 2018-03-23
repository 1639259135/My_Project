package com.lanou.netctoss.base;

public class Page {

    private int pageCode;
    private int pageSize;
    private int totalData;
    private int begin;
    private int end;
    private int num;


    public Page() {
    }

    @Override
    public String toString() {
        return "Page{"
                + "pageCode=" + pageCode
                + ", pageSize=" + pageSize
                + ", totalData=" + totalData
                + ", begin=" + begin
                + ", num=" + num
                + '\''
                + '\''
                + '}';
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getTotalPages() {
        int tp = totalData / pageSize;
        if (totalData % pageSize > 0){
            tp ++;
        }
        return tp;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBegin() {
        return (pageCode - 1) * pageSize;
    }

    public int getNum() {
        if (totalData - begin < pageSize){
            return totalData - begin;
        }else {
            return pageSize;
        }
    }

}
