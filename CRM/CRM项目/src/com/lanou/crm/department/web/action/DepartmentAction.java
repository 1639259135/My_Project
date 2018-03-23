package com.lanou.crm.department.web.action;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.department.service.DepartmentService;
import com.lanou.crm.department.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class DepartmentAction extends ActionSupport {

    private CrmDepartment department;
    private DepartmentService departmentService;

    public String queryAllDep(){
        List<CrmDepartment> crmDepartments = departmentService.queryAllDep();
        ActionContext.getContext().getSession().put("AllDepartment",crmDepartments);
        return SUCCESS;
    }

    public String queryByDepId(){
        CrmDepartment crmDepartment = departmentService.queryByDepId(department.getDepId());
        ActionContext.getContext().getSession().put("depById",crmDepartment);
        return SUCCESS;
    }

    public String addOrEditDepartment(){
        departmentService.addOrEditDepartment(department);
        return SUCCESS;
    }




    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }

    public CrmDepartment getDepartment() {
        return department;
    }

    public void setDepartmentService(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
