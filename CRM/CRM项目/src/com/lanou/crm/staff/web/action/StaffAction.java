package com.lanou.crm.staff.web.action;

import com.lanou.crm.base.action.BaseAction;
import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.staff.domain.CrmStaff;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class StaffAction extends BaseAction<CrmStaff> {

    private CrmDepartment department;
    private CrmStaff staff;
    private String newPwd1;
    private String newPwd2;

    public String login() {
        CrmStaff crmStaff = getStaffService().login(staff);
        if (crmStaff != null){
            toSession("staffName",crmStaff.getStaffName());
            toSession("staffId",crmStaff.getStaffId());
            return SUCCESS;
        }
        toSession("logMessage","用户名或密码错误");
        return "login";
    }

    public String queryAllStaff(){
        List<CrmStaff> list = getStaffService().queryAllStaff();
        toSession("staffs",list);
        return SUCCESS;
    }


    public String queryByStaffName(){
        List<CrmStaff> crmStaffs = getStaffService().queryByStaffName(staff.getStaffName());
        toSession("staffs",crmStaffs);
        return SUCCESS;
    }

    public String queryByStaffId(){
        CrmStaff crmStaff = getStaffService().queryByStaffId(staff.getStaffId());
        toSession("byIdStaff",crmStaff);
        List<CrmDepartment> crmDepartments = getStaffService().queryAllDep();
        toSession("crmDepartments",crmDepartments);
        return SUCCESS;
    }

    public String uploadPwd(){
        return getStaffService().updatePwd(staff,newPwd1,newPwd2);
    }

    public String updateStaff(){
        getStaffService().updateStaff(staff);
        return SUCCESS;
    }

    public String logout(){
        ActionContext.getContext().getSession().remove("staffName");
        return SUCCESS;
    }


    public String getNewPwd1() {
        return newPwd1;
    }

    public void setNewPwd1(String newPwd1) {
        this.newPwd1 = newPwd1;
    }

    public void setNewPwd2(String newPwd2) {
        this.newPwd2 = newPwd2;
    }

    public String getNewPwd2() {
        return newPwd2;
    }

    public CrmStaff getStaff() {
        return staff;
    }

    public void setStaff(CrmStaff staff) {
        this.staff = staff;
    }

    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }

    public CrmDepartment getDepartment() {
        return department;
    }


}
