package com.lanou.netctoss.moduleinfo.domain;

import com.lanou.netctoss.roleinfo.domain.RoleInfo;

import java.util.List;

public class ModuleInfo {
    private Integer moduleId;

    private String name;

    private List<RoleInfo> roleInfos;

    public ModuleInfo(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModuleInfo{" + "moduleId=" + moduleId + ", name='" + name + ", roleInfos='" + roleInfos + '\'' + '}';
    }

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
    }

    public ModuleInfo() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}