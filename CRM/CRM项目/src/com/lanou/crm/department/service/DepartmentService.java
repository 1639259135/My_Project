package com.lanou.crm.department.service;

import com.lanou.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentService {

    List<CrmDepartment> queryAllDep();

    CrmDepartment queryByDepId(String depId);

    void addOrEditDepartment(CrmDepartment depName);

    int queryAllDepCount();

    List<CrmDepartment> limitQueryDep(int begin, int end);

}
