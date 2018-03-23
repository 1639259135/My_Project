package com.lanou.crm.department.dao;

import com.lanou.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentDao {

    List<CrmDepartment> queryAllDep();

    CrmDepartment queryByDepId(String depId);

    void addOrEditDepartment(CrmDepartment department);

    String queryMaxDepId();

    int queryAllDepCount();

    List<CrmDepartment> limitQueryDep(int begin, int end);

}
