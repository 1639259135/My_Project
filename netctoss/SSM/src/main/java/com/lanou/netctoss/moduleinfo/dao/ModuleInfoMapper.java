package com.lanou.netctoss.moduleinfo.dao;

import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;

public interface ModuleInfoMapper {
    int deleteModuleInfoByPrimaryKey(Integer moduleId);

    int insertModuleInfo(ModuleInfo record);

    int insertModuleInfoSelective(ModuleInfo record);

    ModuleInfo selectModuleInfoByPrimaryKey(Integer moduleId);

    int updateModuleInfoByPrimaryKeySelective(ModuleInfo record);

    int updateModuleInfoByPrimaryKey(ModuleInfo record);
}