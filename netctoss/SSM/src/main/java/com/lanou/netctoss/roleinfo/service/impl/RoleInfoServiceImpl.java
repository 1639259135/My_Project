package com.lanou.netctoss.roleinfo.service.impl;

import com.lanou.netctoss.moduleinfo.domain.ModuleInfo;
import com.lanou.netctoss.roleinfo.dao.RoleInfoMapper;
import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import com.lanou.netctoss.roleinfo.domain.RoleInfoPage;
import com.lanou.netctoss.roleinfo.service.RoleInfoService;
import com.lanou.netctoss.rolemodule.domain.RoleModule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Resource
    private RoleModule roleModule;

    public RoleInfoPage findRoleByLimit(RoleInfoPage page) {
        page.setPageSize(6);
        page.setTotalData(roleInfoMapper.findRoleInfoCount());
        List<RoleInfo> roleInfoList = roleInfoMapper.findRoleByLimit(page);
        page.setRoleInfos(roleInfoList);
        return page;
    }

    public void addRole(RoleInfo roleInfo){
        int maxRoleId = roleInfoMapper.findMaxRoleId();
        roleInfo.setRoleId(maxRoleId + 100);
        roleInfoMapper.insertRoleInfoSelective(roleInfo);
        for (ModuleInfo moduleInfo : roleInfo.getModuleInfos()) {
            if (moduleInfo.getModuleId() == null){
                continue;
            }
            roleModule.setRoleId(roleInfo.getRoleId());
            roleModule.setModuleId(moduleInfo.getModuleId());
            roleInfoMapper.insertRoleModuleSelective(roleModule);
        }
    }

    public RoleInfo findRoleById(int id){
        return roleInfoMapper.selectRoleInfoByPrimaryKey(id);
    }

    //TODO update未完成
    public void updateRole(RoleInfo roleInfo){
        roleInfoMapper.updateRoleInfoByPrimaryKeySelective(roleInfo);
    }

    public void deleteRole(RoleInfo roleInfo){
        roleInfoMapper.deleteRoleModuleByRoleId(roleInfo.getRoleId());
        roleInfoMapper.deleteRoleInfoByPrimaryKey(roleInfo.getRoleId());
    }

}
