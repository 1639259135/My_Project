package com.lanou.netctoss.adminrole.dao;

import com.lanou.netctoss.adminrole.domain.AdminRole;

public interface AdminRoleMapper {
    int insertAdminRole(AdminRole record);

    int insertAdminRoleSelective(AdminRole record);
}