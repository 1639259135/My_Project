package com.lanou.crm.department.dao.impl;

import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.department.dao.DepartmentDao;
import com.lanou.crm.department.domain.CrmDepartment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    private String sql = "";
    private CrmDepartment department;

    @Override
    public List<CrmDepartment> queryAllDep() {
        sql = "from CrmDepartment dep";
        List<CrmDepartment> list = (List<CrmDepartment>) this.getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public CrmDepartment queryByDepId(String depId) {
        sql = "from CrmDepartment dep where depId=?";
        List<CrmDepartment> list = (List<CrmDepartment>) this.getHibernateTemplate().find(sql,depId);
        if (list.size() == 0){
            return null ;
        }
       return list.get(0);
    }

    @Override
    public void addOrEditDepartment(CrmDepartment department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public String queryMaxDepId() {
        sql = "select max(depId) from CrmDepartment dep";
        List<CrmDepartment> list = (List<CrmDepartment>) this.getHibernateTemplate().find(sql);
        return list.get(0).getDepId();
    }

    @Override
    public int queryAllDepCount(){
        sql = "select count(*) from CrmDepartment dep";
        Object count = this.getHibernateTemplate().find(sql).listIterator().next();
        return (int) Long.valueOf(String.valueOf(count)).longValue();
    }

    @Override
    public List<CrmDepartment> limitQueryDep(int begin, int end){
        return this.getHibernateTemplate().findByExample(department,begin,end);
    }


    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }
}
