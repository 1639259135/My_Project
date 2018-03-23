package com.lanou.netctoss.admininfo.domain;

import com.lanou.netctoss.base.Page;
import com.lanou.netctoss.roleinfo.domain.RoleInfo;

import java.util.List;

public class AdminInfoPage extends Page {

    private String moduleName;
    private String roleName;
    private int adminId;

    private List<AdminInfoExt> adminInfos;
    private List<RoleInfo> roleInfos;

    public AdminInfoPage() {
    }

    @Override
    public String toString() {
        return "AdminInfoPage{" + "moduleName='" + moduleName + '\'' + ", roleName='" + roleName+ ", adminId='" + adminId + '\'' + ", adminInfos=" + adminInfos + ", roleInfos=" + roleInfos + '}';
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<AdminInfoExt> getAdminInfos() {
        return adminInfos;
    }

    public void setAdminInfos(List<AdminInfoExt> adminInfos) {
        this.adminInfos = adminInfos;
    }
}
