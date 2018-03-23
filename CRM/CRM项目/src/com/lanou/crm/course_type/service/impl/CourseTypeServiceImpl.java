package com.lanou.crm.course_type.service.impl;

import com.lanou.crm.course_type.dao.CourseTypeDao;
import com.lanou.crm.course_type.dao.impl.CourseTypeDaoImpl;
import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.course_type.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

public class CourseTypeServiceImpl implements CourseTypeService {


    private CourseTypeDao courseTypeDao;

    @Override
    public List<CrmCourseType> queryAllType() {
        List<CrmCourseType> crmCourseTypes = courseTypeDao.queryAllType();
        return crmCourseTypes;
    }

    @Override
    public CrmCourseType queryByCTID(String ctId) {
        CrmCourseType crmCourseType = courseTypeDao.queryByCTID(ctId);
        return crmCourseType;
    }

    @Override
    public void addOrEditCourse(CrmCourseType courseType) {
        CrmCourseType crmCourseType = courseTypeDao.queryByCtName(courseType.getCourseName());
        if (crmCourseType == null){
//            String maxId = courseTypeDao.queryMaxCCTId();
//            courseType.setCourseTypeId(maxId + 1);
            courseTypeDao.addCourse(courseType);
            ActionContext.getContext().put("addCourseMessage","添加成功");
        }else {
            courseTypeDao.editCourse(courseType);
            ActionContext.getContext().put("addCourseMessage","修改成功");
        }
    }

    @Override
    public int queryAllTypeCount() {
        return courseTypeDao.queryAllTypeCount();
    }

    @Override
    public List<CrmCourseType> limitQueryType(int begin, int end){
        return courseTypeDao.limitQueryType(begin,end);
    }






    public void setCourseTypeDao(CourseTypeDaoImpl courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }
}
