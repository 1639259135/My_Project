package com.lanou.netctoss.account.dao;

import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.account.domain.AccountPage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    int deleteAccountByPrimaryKey(Integer accountId);

    int insertAccount(AccountExt record);

    int insertAccountSelective(AccountExt record);

    AccountExt selectAccountByPrimaryKey(Integer accountId);

    int updateAccountByPrimaryKeySelective(AccountExt record);

    int updateAccountByPrimaryKey(AccountExt record);

    List<AccountExt> findAccountByLimit(AccountPage page);

    int findAccountCount(AccountPage page);

    int findMaxAccountId();

    AccountExt findByIdcardNo(String idcardNo);

}