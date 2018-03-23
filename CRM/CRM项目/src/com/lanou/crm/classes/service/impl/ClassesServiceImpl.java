package com.lanou.crm.classes.service.impl;

import com.lanou.crm.classes.dao.ClassesDao;
import com.lanou.crm.classes.dao.impl.ClassesDaoImpl;
import com.lanou.crm.classes.domain.CrmClasses;
import com.lanou.crm.classes.service.ClassesService;
import com.lanou.crm.course_type.dao.CourseTypeDao;
import com.lanou.crm.course_type.dao.impl.CourseTypeDaoImpl;
import com.lanou.crm.course_type.domain.CrmCourseType;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {

    private ClassesDao classesDao;
    private CourseTypeDao courseTypeDao;

    @Override
    public List<CrmClasses> queryAllClasses() {
        List<CrmClasses> crmClasses = classesDao.queryAllClasses();
        return crmClasses;
    }

    @Override
    public CrmClasses queryByClaId(String classId) {
        CrmClasses crmClasses = classesDao.queryByClaId(classId);
        List<CrmCourseType> crmCourseTypes = courseTypeDao.queryAllType();
        ActionContext.getContext().getSession().put("allType",crmCourseTypes);
        return crmClasses;
    }

    @Override
    public int queryAllClassCount() {
        return classesDao.queryAllClassCount();
    }

    @Override
    public List<CrmClasses> limitQueryClass(int begin, int end) {
        return classesDao.limitQueryClass(begin, end);
    }

    @Override
    public void editClass(CrmClasses classes) {
        classesDao.editClass(classes);
    }



    public void setClassesDao(ClassesDaoImpl classesDao) {
        this.classesDao = classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }
}
