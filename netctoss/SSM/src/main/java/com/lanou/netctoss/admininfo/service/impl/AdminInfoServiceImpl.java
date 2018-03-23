package com.lanou.netctoss.admininfo.service.impl;

import com.lanou.netctoss.admininfo.dao.AdminInfoMapper;
import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import com.lanou.netctoss.admininfo.domain.AdminInfoPage;
import com.lanou.netctoss.admininfo.service.AdminInfoService;
import com.lanou.netctoss.adminrole.domain.AdminRole;
import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;
    @Resource
    private AdminInfoExt admin;

    @Resource
    private AdminRole adminRole;

    public AdminInfoPage findAdminByLimit(AdminInfoPage page) {
        page.setTotalData(adminInfoMapper.findAdminCount());
        page.setPageSize(9);
        List<AdminInfoExt> adminInfoList = adminInfoMapper.findAdminByLimit(page);
        List<AdminInfoExt> list = new ArrayList<AdminInfoExt>();
        for (AdminInfoExt adminInfoExt : adminInfoList) {
            page.setAdminId(adminInfoExt.getAdminId());
            AdminInfoExt admin = adminInfoMapper.findRoleByIdAdminId(page);
            list.add(admin);
        }
        page.setAdminInfos(list);
        return page;
    }

    public void addAdmin(AdminInfoExt adminInfoExt){
        int maxAdminId = adminInfoMapper.findMaxAdminId();
        adminInfoExt.setAdminId(maxAdminId + 1000);
        adminInfoMapper.insertAdminInfoSelective(adminInfoExt);
        for (ModuleInfo moduleInfo : adminInfoExt.getModuleInfos()) {
            if (moduleInfo.getName() == null){
                continue;
            }
            ModuleInfo m = adminInfoMapper.findModuleInfoByName(moduleInfo);
            for (RoleInfo roleInfo : m.getRoleInfos()) {
                adminRole.setRoleId(roleInfo.getRoleId());
                adminRole.setAdminId(adminInfoExt.getAdminId());
                AdminRole adminRoleById = adminInfoMapper.findAdminRoleByRoleId(roleInfo.getRoleId());
                if (adminRoleById != null){
                    if (adminRoleById.getRoleId().equals(adminRole.getRoleId())){
                        continue;
                    }
                }
                adminInfoMapper.insertAdminRole(adminRole);
            }
        }
    }

    public void deleteAdmin(AdminInfoPage page){
        adminInfoMapper.deleteAdminRoleByAdminId(page);
        adminInfoMapper.deleteAdminInfoByPrimaryKey(page.getAdminId());
    }

    public AdminInfoExt findAdminById(AdminInfoPage page){
        return adminInfoMapper.findRoleByIdAdminId(page);
    }

    public void modiAdmin(AdminInfoExt adminInfoExt){
        List<AdminRole> adminRoles = adminInfoMapper.findAdminRoleByAdminId(adminInfoExt.getAdminId());
        for (ModuleInfo moduleInfo : adminInfoExt.getModuleInfos()) {
            if (moduleInfo.getName() == null){
                continue;
            }
            ModuleInfo m = adminInfoMapper.findModuleInfoByName(moduleInfo);
            for (RoleInfo roleInfo : m.getRoleInfos()) {
                for (AdminRole aRole : adminRoles) {
                    if (!roleInfo.getRoleId().equals(aRole.getRoleId())){
                        adminInfoMapper.deleteAdminRoleByRoleId(aRole);
                    }
                }
                adminRole.setAdminId(adminInfoExt.getAdminId());
                adminRole.setRoleId(roleInfo.getRoleId());
                adminInfoMapper.insertAdminRole(adminRole);
            }
        }
        adminInfoMapper.updateAdminInfoByPrimaryKeySelective(adminInfoExt);
    }

    public void resetPwd(AdminInfoPage page){
        for (AdminInfoExt adminInfoExt : page.getAdminInfos()) {
            if (adminInfoExt == null){
                continue;
            }
            adminInfoExt.setPassword("000000");
            adminInfoMapper.updateAdminInfoByPrimaryKeySelective(adminInfoExt);
        }
    }

    public AdminInfoExt findAdminByAdminCode(AdminInfoExt adminInfoExt, HttpSession session){
        AdminInfoExt adminByAdminCode = adminInfoMapper.findAdminByAdminCode(adminInfoExt.getAdminCode());
        if (adminByAdminCode != null){
            if (adminByAdminCode.getPassword().equals(adminInfoExt.getPassword())){
//                if (adminInfoExt.getImgCode().equals(session.getAttribute("imgCode"))){
                    adminByAdminCode.setResult(0);
                    return adminByAdminCode;
//                }
//                else {
//                    adminByAdminCode.setResult(1);
//                    adminByAdminCode.setResultMsg("验证码错误");
//                    return adminByAdminCode;
//                }
            }
        }
        admin.setResult(1);
        admin.setResultMsg("用户名或密码错误，请重试");
        return admin;
    }

}
