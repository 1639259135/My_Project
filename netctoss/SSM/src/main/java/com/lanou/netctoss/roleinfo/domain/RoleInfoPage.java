package com.lanou.netctoss.roleinfo.domain;

import com.lanou.netctoss.base.Page;

import java.util.List;

public class RoleInfoPage extends Page {

    private List<RoleInfo> roleInfos;

    public RoleInfoPage() {
    }

    @Override
    public String toString() {
        return "RoleInfoPage{" + "roleInfos=" + roleInfos + '}';
    }

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
    }


}
