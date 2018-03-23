package com.lanou.crm.staff.dao.impl;

import com.lanou.crm.staff.dao.StaffDao;
import com.lanou.crm.staff.domain.CrmStaff;
import com.lanou.crm.utils.MD5Util;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

    private String sql = "";

    @Override
    public CrmStaff queryByLog(CrmStaff staff) {
        String logPwd = MD5Util.md5(staff.getLoginPwd());
        sql = "from CrmStaff staff where loginName=? and loginPwd=?";
        List<CrmStaff> list = (List<CrmStaff>) this.getHibernateTemplate().find(
                sql, staff.getLoginName(),logPwd);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CrmStaff> queryAllStaff() {
        sql = "from CrmStaff staf";
        return (List<CrmStaff>) this.getHibernateTemplate().find(sql);
    }

    @Override
    public CrmStaff queryByStaffId(String staffId) {
        sql = "from CrmStaff staff where staffId=?";
        List<CrmStaff> list = (List<CrmStaff>) this.getHibernateTemplate().find(sql, staffId);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public CrmStaff queryByPwd(String staffPwd) {
        String s = MD5Util.md5(staffPwd);
        sql = "from CrmStaff staff where loginPwd=?";
        List<CrmStaff> list = (List<CrmStaff>) this.getHibernateTemplate().find(sql, s);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void updatePwd(CrmStaff crmStaff){
        CrmStaff staff = this.getHibernateTemplate().get(CrmStaff.class, crmStaff.getStaffId());
        staff.setLoginPwd(MD5Util.md5(crmStaff.getLoginPwd()));
        this.getHibernateTemplate().save(staff);
    }

    @Override
    public void updateByStaffId(CrmStaff staff) {
        CrmStaff crmStaff = this.getHibernateTemplate().get(CrmStaff.class, staff.getStaffId());
        crmStaff.setStaffName(staff.getStaffName());
        crmStaff.setGender(staff.getGender());
        crmStaff.setLoginName(staff.getLoginName());
        crmStaff.setOnDutyDate(staff.getOnDutyDate());
        crmStaff.setPostId(staff.getCrmPost().getPostId());
        crmStaff.setLoginPwd(MD5Util.md5(staff.getLoginPwd()));
        this.getHibernateTemplate().save(crmStaff);
    }

    @Override
    public List<CrmStaff> queryByStaffName(String staffName) {
        sql = "from CrmStaff staff where staffName=?";
        List<CrmStaff> list = (List<CrmStaff>) this.getHibernateTemplate().find(sql, staffName);
        return list;
    }

}
