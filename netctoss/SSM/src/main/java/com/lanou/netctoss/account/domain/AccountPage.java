package com.lanou.netctoss.account.domain;

import com.lanou.netctoss.base.Page;

import java.util.List;

public class AccountPage extends Page {

    private String status;
    private List<AccountExt> accounts;

    @Override
    public String toString() {
        return "AccountPage{" + "status='" + status + '\'' + ", accounts=" + accounts + '}';
    }

    public List<AccountExt> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountExt> accounts) {
        this.accounts = accounts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
