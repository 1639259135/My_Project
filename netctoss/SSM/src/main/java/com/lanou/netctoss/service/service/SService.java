package com.lanou.netctoss.service.service;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.service.domain.Service;
import com.lanou.netctoss.service.domain.ServicePage;

public interface SService {

    ServicePage findServiceByPage(ServicePage servicePage);

    void insertService(Service service);

    void deleteService(Service service);

    void openOrCloseService(Service service);

    Service findServiceById(Service service);

    AccountExt findAccountByIdcard(String iscardNo);

}
