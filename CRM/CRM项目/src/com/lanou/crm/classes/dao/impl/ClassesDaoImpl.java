package com.lanou.crm.classes.dao.impl;

import com.lanou.crm.classes.dao.ClassesDao;
import com.lanou.crm.classes.domain.CrmClasses;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

    private String sql = "";
    private CrmClasses classes;

    @Override
    public List<CrmClasses> queryAllClasses() {
        sql = "from CrmClasses ccs";
        List<CrmClasses> list = (List<CrmClasses>) this.getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public CrmClasses queryByClaId(String classId) {
        sql = "from CrmClasses ccs where classId=?";
        List<CrmClasses> list = (List<CrmClasses>) this.getHibernateTemplate().find(sql,classId);
        return list.get(0);
    }

    @Override
    public void editClass(CrmClasses classes) {
        CrmClasses crmClasses = this.getHibernateTemplate().get(CrmClasses.class, classes.getClassId());
        crmClasses.setName(classes.getName());
        crmClasses.setCrmCourseType(crmClasses.getCrmCourseType());
        crmClasses.setRemark(classes.getRemark());
        this.getHibernateTemplate().save(crmClasses);
    }

    @Override
    public int queryAllClassCount() {
        sql = "select count(*) from CrmClasses";
        Object count = this.getHibernateTemplate().find(sql).listIterator().next();
        return (int) Long.valueOf(String.valueOf(count)).longValue();
    }

    @Override
    public List<CrmClasses> limitQueryClass(int begin, int end) {
        return this.getHibernateTemplate().findByExample(classes, begin, (end - begin));
    }

    public void setClasses(CrmClasses classes) {
        this.classes = classes;
    }
}
