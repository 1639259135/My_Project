package com.lanou.crm.staff.dao;

import com.lanou.crm.post.domain.CrmPost;
import com.lanou.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffDao {

    CrmStaff queryByLog(CrmStaff staff);

    List<CrmStaff> queryAllStaff();

    CrmStaff queryByStaffId(String staffId);

    List<CrmStaff> queryByStaffName(String staffName);

    CrmStaff queryByPwd(String staffPwd);

    void updatePwd(CrmStaff staff);

    void updateByStaffId(CrmStaff staff);

}
