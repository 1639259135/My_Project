package com.lanou.netctoss.admininfo.domain;

import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AdminInfoExt extends AdminInfo {

    private String imgCode;
    private int result;
    private String resultMsg;


    private List<RoleInfo> roleInfos;
    private List<ModuleInfo> moduleInfos;

    public AdminInfoExt(Integer adminId, String adminCode, String password, String name, String telephone, String email, Date enrolldate) {
        super(adminId, adminCode, password, name, telephone, email, enrolldate);
    }

    public AdminInfoExt() {
    }

    @Override
    public String toString() {
        return "AdminInfoExt{" + "imgCode='" + imgCode + '\'' + ", result='" + result + '\'' + ", resultMsg='" + resultMsg + '\'' + ", roleInfos=" + roleInfos + ", moduleInfos=" + moduleInfos + '}';
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
    }

    public List<ModuleInfo> getModuleInfos() {
        return moduleInfos;
    }

    public void setModuleInfos(List<ModuleInfo> moduleInfos) {
        this.moduleInfos = moduleInfos;
    }
}
