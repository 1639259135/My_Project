package com.lanou.crm.course_type.service;

import com.lanou.crm.course_type.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeService {

    List<CrmCourseType> queryAllType();

    CrmCourseType queryByCTID(String ctId);

    void addOrEditCourse(CrmCourseType courseType);

    int queryAllTypeCount();

    List<CrmCourseType> limitQueryType(int begin, int end);

}
