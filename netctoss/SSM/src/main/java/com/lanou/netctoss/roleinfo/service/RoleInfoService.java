package com.lanou.netctoss.roleinfo.service;

import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import com.lanou.netctoss.roleinfo.domain.RoleInfoPage;

public interface RoleInfoService {

    RoleInfoPage findRoleByLimit(RoleInfoPage page);

    void addRole(RoleInfo roleInfo);

    RoleInfo findRoleById(int id);

    void updateRole(RoleInfo roleInfo);

    void deleteRole(RoleInfo roleInfo);


}
