package com.lanou.netctoss.admininfo.dao;

import com.lanou.netctoss.admininfo.domain.AdminInfo;
import com.lanou.netctoss.admininfo.domain.AdminInfoExt;
import com.lanou.netctoss.admininfo.domain.AdminInfoPage;
import com.lanou.netctoss.adminrole.domain.AdminRole;
import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInfoMapper {

    int deleteAdminInfoByPrimaryKey(Integer adminId);

    int insertAdminInfo(AdminInfo record);

    int insertAdminInfoSelective(AdminInfo record);

    AdminInfoExt selectAdminInfoByPrimaryKey(Integer adminId);

    int updateAdminInfoByPrimaryKeySelective(AdminInfoExt record);

    int updateAdminInfoByPrimaryKey(AdminInfoExt record);

    int findAdminCount();

    List<AdminInfoExt> findAdminByLimit(AdminInfoPage page);

    AdminInfoExt findRoleByIdAdminId(AdminInfoPage page);

    ModuleInfo findModuleInfoByName(ModuleInfo moduleInfo);

    int findMaxAdminId();

    void insertAdminRole(AdminRole adminRole);

    AdminRole findAdminRoleByRoleId(int roleId);

    void deleteAdminRoleByAdminId(AdminInfoPage page);

    List<AdminRole> findAdminRoleByAdminId(int adminId);

    void deleteAdminRoleByRoleId(AdminRole adminRole);

    AdminInfoExt findAdminByAdminCode(String adminCode);

}