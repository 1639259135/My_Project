package com.lanou.crm.classes.web.action;

import com.lanou.crm.classes.domain.CrmClasses;
import com.lanou.crm.classes.service.ClassesService;
import com.lanou.crm.classes.service.impl.ClassesServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ClassesAction extends ActionSupport {

    private CrmClasses classes;
    private ClassesService classesService;

    public String queryAllClasses(){
        List<CrmClasses> crmClasses = classesService.queryAllClasses();
        ActionContext.getContext().getSession().put("allClasses",crmClasses);
        return SUCCESS;
    }

    public String queryByClaId(){
        CrmClasses crmClasses = classesService.queryByClaId(classes.getClassId());
        ActionContext.getContext().getSession().put("classByClassId",crmClasses);
        return SUCCESS;
    }

    public String editClass(){
        classesService.editClass(classes);
        return SUCCESS;
    }













    public void setClasses(CrmClasses classes) {
        this.classes = classes;
    }

    public CrmClasses getClasses() {
        return classes;
    }

    public void setClassesService(ClassesServiceImpl classesService) {
        this.classesService = classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }
}
