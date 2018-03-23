package com.lanou.netctoss.admininfo.service;

import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import com.lanou.netctoss.admininfo.domain.AdminInfoPage;

import javax.servlet.http.HttpSession;

public interface AdminInfoService {

    AdminInfoPage findAdminByLimit(AdminInfoPage page);

    void addAdmin(AdminInfoExt adminInfoExt);

    void deleteAdmin(AdminInfoPage page);

    AdminInfoExt findAdminById(AdminInfoPage page);

    void modiAdmin(AdminInfoExt adminInfoExt);

    void resetPwd(AdminInfoPage page);

    AdminInfoExt findAdminByAdminCode(AdminInfoExt adminInfoExt, HttpSession session);




}
