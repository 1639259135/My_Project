package com.lanou.netctoss.service.dao;

import com.lanou.netctoss.service.domain.Service;
import com.lanou.netctoss.service.domain.ServicePage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMapper {
    int deleteServiceByPrimaryKey(Integer serviceId);

    int insertService(Service record);

    int insertServiceSelective(Service record);

    Service selectServiceByPrimaryKey(Integer serviceId);

    int updateServiceByPrimaryKeySelective(Service record);

    int updateServiceByPrimaryKey(Service record);

    int findServiceCount(ServicePage servicePage);

    List<Service> findServiceByPage(ServicePage page);

    int findServiceMaxId();
}