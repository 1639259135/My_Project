package com.lanou.netctoss.service.service.impl;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.account.service.AccountService;
import com.lanou.netctoss.service.dao.ServiceMapper;
import com.lanou.netctoss.service.domain.ServicePage;
import com.lanou.netctoss.service.service.SService;
import com.lanou.netctoss.service.domain.Service;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.stereotype.Service
public class SServiceImpl implements SService {

    @Resource
    private ServiceMapper serviceMapper;

    @Resource
    private AccountService accountService;

    public ServicePage findServiceByPage(ServicePage page) {
        page.setTotalData(serviceMapper.findServiceCount(page));
        page.setPageSize(6);
        List<Service> serviceList = serviceMapper.findServiceByPage(page);
        page.setServiceList(serviceList);
        return page;
    }

    public AccountExt findAccountByIdcard(String iscardNo){
        return accountService.findAccountByIdcardIdcard(iscardNo);
    }

    public void insertService(Service service) {
        AccountExt a = accountService.findAccountByIdcardIdcard(service.getAccount().getIdcardNo());
        int maxId = serviceMapper.findServiceMaxId();
        service.setServiceId(maxId + 1);
        service.setStatus("1");
        System.out.println(service);
        serviceMapper.insertServiceSelective(service);
    }

    public void deleteService(Service service){
        service.setStatus("2");
        serviceMapper.updateServiceByPrimaryKeySelective(service);
    }

    public void openOrCloseService(Service service){
        Service s = serviceMapper.selectServiceByPrimaryKey(service.getServiceId());
        if (s.getStatus().equals("0")){
            s.setStatus("1");
        }else {
            s.setStatus("0");
        }
        serviceMapper.updateServiceByPrimaryKeySelective(s);
    }

    public Service findServiceById(Service service){
        return serviceMapper.selectServiceByPrimaryKey(service.getServiceId());
    }

}
