package com.lanou.netctoss.account.service;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.account.domain.AccountPage;

public interface AccountService {

    AccountPage findByLimit(AccountPage page);

    AccountExt findByAccountId(int id);

    void updateAccount(AccountExt account);

    void addAccount(AccountExt account);

    void deleteAccount(AccountExt account);

    void openOrCloseAccount(AccountExt account);

    AccountExt findAccountByIdcardIdcard(String idcardNo);

}
