package com.lanou.crm.paging.web.action;

import com.lanou.crm.course_type.domain.CrmCourseType;
import com.lanou.crm.course_type.service.impl.CourseTypeServiceImpl;
import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.department.service.impl.DepartmentServiceImpl;
import com.lanou.crm.staff.service.impl.StaffServiceImpl;
import com.lanou.crm.utils.PageUtil;
import com.lanou.crm.classes.domain.CrmClasses;
import com.lanou.crm.classes.service.impl.ClassesServiceImpl;
import com.lanou.crm.paging.domain.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class PageAction extends ActionSupport {

    private Page page;
    private ClassesServiceImpl classesService;
    private CourseTypeServiceImpl courseTypeService;
    private StaffServiceImpl staffService;
    private DepartmentServiceImpl departmentService;

    public String classPage(){
        PageUtil.handle(page, classesService.queryAllClassCount(), new PageUtil.ResultHandle() {
            @Override
            public void resultPage(int begin, int end) {
                List<CrmClasses> crmClasses = classesService.limitQueryClass(begin, end);
                page.setClassesList(crmClasses);
            }
        });
        return SUCCESS;
    }

    public String courseTypePage(){
        PageUtil.handle(page, courseTypeService.queryAllTypeCount(), new PageUtil.ResultHandle() {
            @Override
            public void resultPage(int begin, int end) {
                List<CrmCourseType> typeList = courseTypeService.limitQueryType(begin, end);
                page.setCourseTypeList(typeList);
            }
        });
        return SUCCESS;
    }

    public String depPage(){
        PageUtil.handle(page, departmentService.queryAllDepCount(), new PageUtil.ResultHandle() {
            @Override
            public void resultPage(int begin, int end) {
                List<CrmDepartment> departmentList = departmentService.limitQueryDep(begin, end);
                page.setDepartmentList(departmentList);
            }
        });
        return SUCCESS;
    }


    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public void setClassesService(ClassesServiceImpl classesService) {
        this.classesService = classesService;
    }

    public ClassesServiceImpl getClassesService() {
        return classesService;
    }

    public void setCourseTypeService(CourseTypeServiceImpl courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public CourseTypeServiceImpl getCourseTypeService() {
        return courseTypeService;
    }

    public void setStaffService(StaffServiceImpl staffService) {
        this.staffService = staffService;
    }

    public StaffServiceImpl getStaffService() {
        return staffService;
    }

    public void setDepartmentService(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    public DepartmentServiceImpl getDepartmentService() {
        return departmentService;
    }
}
