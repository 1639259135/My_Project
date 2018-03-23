package com.lanou.crm.base.action;

import com.lanou.crm.classes.service.ClassesService;
import com.lanou.crm.department.service.DepartmentService;
import com.lanou.crm.post.service.PostService;
import com.lanou.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.lang.reflect.ParameterizedType;

public class BaseAction<T> extends ActionSupport {

    private final Class<T> actionClass;

    private StaffService staffService;
    private PostService postService;
    private DepartmentService departmentService;
    private ClassesService classesService;


    public BaseAction() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.actionClass = (Class<T>) type.getActualTypeArguments()[0];
//        System.out.println("actionClass----->" + actionClass);
    }

    public void toSession(String key, Object value){
        ActionContext.getContext().getSession().put(key,value);
    }

    public void toContext(String key,Object value){
        ActionContext.getContext().put(key,value);
    }

    public void toApplication(String key,Object value){
        ActionContext.getContext().getApplication().put(key,value);
    }

    public void setRootStack(String key, Object value){
        ActionContext.getContext().getValueStack().set(key,value);
    }

    public void putRootStack(Object o){
        ActionContext.getContext().getValueStack().push(o);
    }



    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public ClassesService getClassesService() {
        return classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }
}
