package com.lanou.crm.paging.domain;

import com.lanou.crm.classes.domain.CrmClasses;
import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.department.domain.CrmDepartment;

import java.util.List;


public class Page {

    private int pageCode;
    private int pageSize = 5;
    private int totalData;
    private String params;
    private List<CrmClasses> classesList;
    private List<CrmCourseType> courseTypeList;
    private List<CrmDepartment> departmentList;

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" + "pageCode=" + pageCode + ", pageSize=" + pageSize + ", totalData=" + totalData + ", params='" + params + '\'' + ", classesList=" + classesList + ", courseTypeList=" + courseTypeList + '}';
    }

    public List<CrmDepartment> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<CrmDepartment> departmentList) {
        this.departmentList = departmentList;
    }

    public List<CrmClasses> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<CrmClasses> classesList) {
        this.classesList = classesList;
    }

    public List<CrmCourseType> getCourseTypeList() {
        return courseTypeList;
    }

    public void setCourseTypeList(List<CrmCourseType> courseTypeList) {
        this.courseTypeList = courseTypeList;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getTotalData() {
        return totalData;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getTotalpages(){
        int pc = totalData / pageSize;
        if (totalData % pageSize > 0){
            pc ++;
        }
        return pc;
    }
}
