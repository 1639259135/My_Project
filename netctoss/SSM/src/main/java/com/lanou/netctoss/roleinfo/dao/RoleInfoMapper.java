package com.lanou.netctoss.roleinfo.dao;

import com.lanou.netctoss.base.Page;
import com.lanou.netctoss.roleinfo.domain.RoleInfo;
import com.lanou.netctoss.rolemodule.domain.RoleModule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleInfoMapper {

    int deleteRoleInfoByPrimaryKey(Integer roleId);

    int insertRoleInfo(RoleInfo record);

    int insertRoleInfoSelective(RoleInfo record);

    RoleInfo selectRoleInfoByPrimaryKey(Integer roleId);

    int updateRoleInfoByPrimaryKeySelective(RoleInfo record);

    int updateRoleInfoByPrimaryKey(RoleInfo record);

    List<RoleInfo> findRoleByLimit(Page page);

    int findRoleInfoCount();

    int findMaxRoleId();

    int deleteRoleModuleByRoleId(int roleId);

    int insertRoleModuleSelective(RoleModule record);
}
//<delete id="deleteRoleModuleByRoleId" parameterType="int">
//        delete from role_module
//        where role_id = #{roleId,jdbcType=INTEGER}
//</delete>
//
//<insert id="insertRoleModuleSelective" parameterType="com.lanou.netctoss.rolemodule.domain.RoleModule">
//        insert into role_module
//<trim prefix="(" suffix=")" suffixOverrides=",">
//<if test="roleId != null">
//        role_id,
//</if>
//<if test="moduleId != null">
//        module_id,
//</if>
//</trim>
//<trim prefix="values (" suffix=")" suffixOverrides=",">
//<if test="roleId != null">
//        #{roleId,jdbcType=INTEGER},
//</if>
//<if test="moduleId != null">
//        #{moduleId,jdbcType=INTEGER},
//</if>
//</trim>
//</insert>