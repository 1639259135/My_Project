package com.lanou.netctoss.roleinfo.domain;

import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import com.lanou.netctoss.rolemodule.domain.RoleModule;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;

    private List<ModuleInfo> moduleInfos;

    public RoleInfo(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleInfo{" + "roleId=" + roleId + ", name='" + name + '\'' + ", moduleInfos=" + moduleInfos + '}';
    }

    public List<ModuleInfo> getModuleInfos() {
        return moduleInfos;
    }

    public void setModuleInfos(List<ModuleInfo> moduleInfos) {
        this.moduleInfos = moduleInfos;
    }

    public RoleInfo() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}