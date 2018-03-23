package com.lanou.crm.course_type.web.action;

import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.course_type.service.CourseTypeService;
import com.lanou.crm.course_type.service.impl.CourseTypeServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class courseTypeAction extends ActionSupport {

    private CourseTypeService courseTypeService;
    private CrmCourseType courseType;

    public String queryAllType(){
        List<CrmCourseType> crmCourseTypes = courseTypeService.queryAllType();
        ActionContext.getContext().getSession().put("allType",crmCourseTypes);
        return SUCCESS;
    }

    public String queryByCTID(){
        CrmCourseType crmCourseType = courseTypeService.queryByCTID(courseType.getCourseTypeId());
        ActionContext.getContext().getSession().put("queryByCTID",crmCourseType);
        return SUCCESS;
    }

    public String addOrEditCourse(){
        System.out.println(courseType);
        courseTypeService.addOrEditCourse(courseType);
        return SUCCESS;
    }














    public void setCourseTypeService(CourseTypeServiceImpl courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public void setCourseType(CrmCourseType courseType) {
        this.courseType = courseType;
    }

    public CrmCourseType getCourseType() {
        return courseType;
    }
}
