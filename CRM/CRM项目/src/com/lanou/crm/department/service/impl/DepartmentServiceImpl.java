package com.lanou.crm.department.service.impl;

import com.lanou.crm.department.dao.DepartmentDao;
import com.lanou.crm.department.dao.impl.DepartmentDaoImpl;
import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.department.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentDao departmentDao;

    @Override
    public List<CrmDepartment> queryAllDep() {
        List<CrmDepartment> crmDepartments = departmentDao.queryAllDep();
        return crmDepartments;
    }

    @Override
    public CrmDepartment queryByDepId(String depId) {
        CrmDepartment crmDepartment = departmentDao.queryByDepId(depId);
        return crmDepartment;
    }

    @Override
    public void addOrEditDepartment(CrmDepartment department) {
        String maxDepId = departmentDao.queryMaxDepId();
        department.setDepId(maxDepId);
        departmentDao.addOrEditDepartment(department);
    }

    @Override
    public int queryAllDepCount(){
        return departmentDao.queryAllDepCount();
    }

    @Override
    public List<CrmDepartment> limitQueryDep(int begin, int end){
        return departmentDao.limitQueryDep(begin,end);
    }




    public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
