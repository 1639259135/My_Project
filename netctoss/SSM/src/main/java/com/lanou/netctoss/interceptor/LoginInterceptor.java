package com.lanou.netctoss.interceptor;

import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        AdminInfoExt adminInfoExt = (AdminInfoExt) session.getAttribute("loginAdmin");
        System.out.println(adminInfoExt.getName());
        if (adminInfoExt.getName() != null){
            return true;
        }
        request.getRequestDispatcher("../../login.jsp").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
