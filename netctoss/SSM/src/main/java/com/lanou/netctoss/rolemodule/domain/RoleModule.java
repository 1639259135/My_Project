package com.lanou.netctoss.rolemodule.domain;

import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import org.springframework.stereotype.Component;

@Component
public class RoleModule {
    private Integer roleId;

    private Integer moduleId;

    private ModuleInfo moduleInfo;

    public RoleModule(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "RoleModule{" + "roleId=" + roleId + ", moduleId=" + moduleId + ", moduleInfo=" + moduleInfo + '}';
    }

    public RoleModule() {
        super();
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}