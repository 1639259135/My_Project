package com.lanou.crm.course_type.dao;

import com.lanou.crm.course_type.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeDao {

    List<CrmCourseType> queryAllType();

    CrmCourseType queryByCTID(String ctId);

    CrmCourseType queryByCtName(String ctName);

//    String queryMaxCCTId();

    void addCourse(CrmCourseType courseType);

    void editCourse(CrmCourseType courseType);

    int queryAllTypeCount();

    List<CrmCourseType> limitQueryType(int begin, int end);



}
