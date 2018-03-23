package com.lanou.crm.staff.service.impl;

import com.lanou.crm.base.dao.BaseDao;
import com.lanou.crm.base.dao.impl.BaseDaoImpl;
import com.lanou.crm.department.dao.DepartmentDao;
import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.staff.dao.StaffDao;
import com.lanou.crm.staff.domain.CrmStaff;
import com.lanou.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;
    private DepartmentDao departmentDao;

    @Override
    public CrmStaff login(CrmStaff staff) {
        CrmStaff crmStaff = staffDao.queryByLog(staff);
        return crmStaff;
    }

    @Override
    public List<CrmStaff> queryAllStaff() {
        List<CrmStaff> list = staffDao.queryAllStaff();
        return list;
    }

    @Override
    public List<CrmStaff> queryByStaffName(String staffName) {
        List<CrmStaff> list = staffDao.queryByStaffName(staffName);
        return list;
    }

    @Override
    public CrmStaff queryByStaffId(String staffId) {
        CrmStaff crmStaff = staffDao.queryByStaffId(staffId);
        return crmStaff;
    }

    @Override
    public String updatePwd(CrmStaff staff,String newPwd1,String newPwd2) {
        CrmStaff crmStaff = staffDao.queryByPwd(staff.getLoginPwd());
        if (crmStaff == null){
            ActionContext.getContext().getSession().put("updPwdMessage","原密码错误,请重新输入");
            return "input";
        }
        if (newPwd1.equals(newPwd2)){
            if (newPwd1 == null){
                ActionContext.getContext().getSession().put("updPwdMessage","请输入新密码");
                return "input";
            }
            staff.setLoginPwd(newPwd1);
            staffDao.updatePwd(staff);
            return "success";
        }
        ActionContext.getContext().getSession().put("newPwdMessage","新密码输入不一致,请重新输入");
        return "input";

    }

    @Override
    public List<CrmDepartment> queryAllDep() {
        List<CrmDepartment> crmDepartments = departmentDao.queryAllDep();
        return crmDepartments;
    }

    @Override
    public void updateStaff(CrmStaff staff) {
        staffDao.updateByStaffId(staff);
    }



    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
