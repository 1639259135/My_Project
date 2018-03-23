package com.lanou.netctoss.service.domain;

import com.lanou.netctoss.base.Page;

import java.util.List;

public class ServicePage extends Page {

    private String osUsername;
    private String unixHost;
    private String idcardNo;
    private String status;

    private List<Service> serviceList;

    @Override
    public String toString() {
        return "ServicePage{" + "osUsername='" + osUsername + '\'' + ", unixHost='" + unixHost + '\'' + ", idcardNo='" + idcardNo + '\'' + ", status='" + status + '\'' + ", serviceList=" + serviceList + '}';
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public String getOsUsername() {
        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername;
    }

    public String getUnixHost() {
        return unixHost;
    }

    public void setUnixHost(String unixHost) {
        this.unixHost = unixHost;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
