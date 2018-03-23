package com.lanou.crm.classes.dao;

import com.lanou.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesDao {

    List<CrmClasses> queryAllClasses();

    void editClass(CrmClasses classes);

    CrmClasses queryByClaId(String classId);

    int queryAllClassCount();

    List<CrmClasses> limitQueryClass(int begin,int end);

}
