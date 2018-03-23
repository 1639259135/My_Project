package com.lanou.crm.course_type.dao.impl;

import com.lanou.crm.course_type.dao.CourseTypeDao;
import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.utils.MD5Util;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

    private String sql = "";
    private CrmCourseType courseType;

    @Override
    public List<CrmCourseType> queryAllType() {
        sql = "from CrmCourseType cct";
        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public CrmCourseType queryByCTID(String ctId) {
        sql = "from CrmCourseType cct where courseTypeId=?";
        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find(sql, ctId);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public CrmCourseType queryByCtName(String ctName) {
        sql = "from CrmCourseType cct where courseName=?";
        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find(sql, ctName);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void addCourse(CrmCourseType courseType) {
        this.getHibernateTemplate().save(courseType);
    }

    @Override
    public void editCourse(CrmCourseType courseType) {
        CrmCourseType crmCourseType = this.getHibernateTemplate().get(CrmCourseType.class, courseType.getCourseTypeId());
        crmCourseType.setCourseName(courseType.getCourseName());
        crmCourseType.setCourseCost(courseType.getCourseCost());
        crmCourseType.setTotal(courseType.getTotal());
        crmCourseType.setRemark(courseType.getRemark());
        this.getHibernateTemplate().save(crmCourseType);
    }

    @Override
    public int queryAllTypeCount() {
        sql = "select count(*) from CrmCourseType cct";
        Object count = this.getHibernateTemplate().find(sql).listIterator().next();
        return (int) Long.valueOf(String.valueOf(count)).longValue();
    }

    @Override
    public List<CrmCourseType> limitQueryType(int begin, int end) {
        return this.getHibernateTemplate().findByExample(courseType, begin, end);
    }


//    @Override
//    public String queryMaxCCTId() {
//        sql = "select amx(courseTypeId) from CrmCourseType cct";
//        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find(sql);
//        return list.get(0).getCourseTypeId();
//    }


    public void setCourseType(CrmCourseType courseType) {
        this.courseType = courseType;
    }
}
