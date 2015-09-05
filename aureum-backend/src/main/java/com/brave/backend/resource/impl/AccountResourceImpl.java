package com.brave.backend.resource.impl;

import com.brave.backend.dao.AccountDao;
import com.brave.backend.resource.AccountResource;

// 注解式事务
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
public class AccountResourceImpl implements AccountResource
{
    private AccountDao accountDao;
    
    public void setAccountDao(AccountDao accountDao)
    {
        this.accountDao = accountDao;
    }
    
    @Override
    //    @Transactional
    public void transfer(String out, String in, double num)
    {
        //        int r = accountDao.deductMoney(out, num);
        //        if (r > 0)
        //        {
        //            throw new RuntimeException();
        //        }
        accountDao.deductMoney(out, num);
        accountDao.addMoney(in, num);
    }
    
}
