package com.lanou.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object staffName = ActionContext.getContext().getSession().get("staffName");
//        System.out.println("interceptor-----" + staffName);
        if (staffName != null){
            return actionInvocation.invoke();
        }
        return "login";
    }
}
