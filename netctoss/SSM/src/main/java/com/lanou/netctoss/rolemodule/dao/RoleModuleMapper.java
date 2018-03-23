package com.lanou.netctoss.rolemodule.dao;

import com.lanou.netctoss.rolemodule.domain.RoleModule;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModuleMapper {

    int insertRoleModule(RoleModule record);

    int insertRoleModuleSelective(RoleModule record);

}