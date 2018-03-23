package com.lanou.crm.classes.service;

import com.lanou.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesService {

    List<CrmClasses> queryAllClasses();

    void editClass(CrmClasses classes);

    CrmClasses queryByClaId(String classId);

    int queryAllClassCount();

    List<CrmClasses> limitQueryClass(int begin, int end);

}
