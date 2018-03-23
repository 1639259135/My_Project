package com.lanou.crm.staff.service;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.post.domain.CrmPost;
import com.lanou.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffService {

    CrmStaff login(CrmStaff staff);

    List<CrmStaff> queryAllStaff();

    CrmStaff queryByStaffId(String staffId);

    List<CrmStaff> queryByStaffName(String staffName);

    void updateStaff(CrmStaff staff);

    String updatePwd(CrmStaff staff,String newPwd1,String newPwd2);

    List<CrmDepartment> queryAllDep();

}
