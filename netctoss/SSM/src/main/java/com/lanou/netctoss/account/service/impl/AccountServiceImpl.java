package com.lanou.netctoss.account.service.impl;

import com.lanou.netctoss.account.dao.AccountMapper;
import com.lanou.netctoss.account.domain.AccountExt;
import com.lanou.netctoss.account.domain.AccountPage;
import com.lanou.netctoss.account.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    private Date date = new Date();

    public AccountPage findByLimit(AccountPage page) {
        page.setPageSize(2);
        page.setTotalData(accountMapper.findAccountCount(page));
        List<AccountExt> accountList = accountMapper.findAccountByLimit(page);
        page.setAccounts(accountList);
        return page;
    }

    public AccountExt findByAccountId(int id) {
        AccountExt account = accountMapper.selectAccountByPrimaryKey(id);
        AccountExt a = accountMapper.selectAccountByPrimaryKey(account.getRecommenderId());
        if (a != null){
            account.setRecommenderIdcard(a.getIdcardNo());
        }
        return account;
    }

    public void updateAccount(AccountExt account){
        AccountExt a = accountMapper.findByIdcardNo(account.getRecommenderIdcard());
        account.setRecommenderId(a.getAccountId());
        accountMapper.updateAccountByPrimaryKeySelective(account);
    }

    public void addAccount(AccountExt account) {
        account.setStatus("1");
        AccountExt byIdcardNo = accountMapper.findByIdcardNo(account.getRecommenderIdcard());
        account.setRecommenderId(byIdcardNo.getAccountId());
        int maxAccountId = accountMapper.findMaxAccountId();
        account.setAccountId(maxAccountId + 1);
        account.setPauseDate(date);
        account.setCloseDate(date);
        account.setLastLoginTime(date);
        int i = 6;//截取字符的起点
        String y = account.getIdcardNo().substring(i, i+4);//截取年
        String m = account.getIdcardNo().substring(i+4, i+6);//截取月
        String d = account.getIdcardNo().substring(i+6, i+8);//截取日
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date day = null;
        try {
            day = formatter.parse( y + "-" + m + "-" + d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        account.setBirthdate(day);
        accountMapper.insertAccountSelective(account);
    }

    public void deleteAccount(AccountExt account){
        account.setStatus("2");
        account.setCloseDate(date);
        account.setLastLoginTime(date);
        accountMapper.updateAccountByPrimaryKeySelective(account);
    }

    public void openOrCloseAccount(AccountExt account){
        AccountExt a = accountMapper.selectAccountByPrimaryKey(account.getAccountId());
        if (a.getStatus().equals("1")){
            a.setStatus("0");
            a.setPauseDate(date);
        }else {
            a.setStatus("1");
            a.setCreateDate(date);
        }
        accountMapper.updateAccountByPrimaryKeySelective(a);
    }

    public AccountExt findAccountByIdcardIdcard(String idcardNo){
        return accountMapper.findByIdcardNo(idcardNo);
    }

}
