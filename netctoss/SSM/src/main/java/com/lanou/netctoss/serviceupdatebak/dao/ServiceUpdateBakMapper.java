package com.lanou.netctoss.serviceupdatebak.dao;

import com.lanou.netctoss.serviceupdatebak.domain.ServiceUpdateBak;

public interface ServiceUpdateBakMapper {
    int deleteSUBByPrimaryKey(Integer id);

    int insertSUB(ServiceUpdateBak record);

    int insertSUBSelective(ServiceUpdateBak record);

    ServiceUpdateBak selectSUBByPrimaryKey(Integer id);

    int updateSUBByPrimaryKeySelective(ServiceUpdateBak record);

    int updateSUBByPrimaryKey(ServiceUpdateBak record);
}