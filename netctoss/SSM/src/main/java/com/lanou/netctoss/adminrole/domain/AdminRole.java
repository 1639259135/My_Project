package com.lanou.netctoss.adminrole.domain;

import org.springframework.stereotype.Component;

@Component
public class AdminRole {
    private Integer adminId;

    private Integer roleId;

    public AdminRole(Integer adminId, Integer roleId) {
        this.adminId = adminId;
        this.roleId = roleId;
    }

    public AdminRole() {
        super();
    }

    @Override
    public String toString() {
        return "AdminRole{" + "adminId=" + adminId + ", roleId=" + roleId + '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}