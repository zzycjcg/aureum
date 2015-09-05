package com.brave.backend.dao.impl;

import com.brave.backend.dao.AccountDao;
import com.brave.backend.dao.model.Account;
import com.brave.foundation.dao.impl.BaseDaoImpl;

/**
 * <描述.>
 *
 * @author 	ZZY
 * @date 	2015年9月5日
 */
public class AccountDaoImpl extends BaseDaoImpl<Account>implements AccountDao
{
    
    /** {@inheritDoc} */
    
    @Override
    public int addMoney(String profileID, double num)
    {
        return updateMoney("addMoney", profileID, num);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public int deductMoney(String profileID, double num)
    {
        return updateMoney("deductMoney", profileID, num);
    }
    
    /**
     * Update money.
     *
     * @param sqlID the sql id
     * @param profileID the profile id
     * @param num the num
     * @return the int
     */
    private int updateMoney(String sqlID, String profileID, double num)
    {
        Account account = new Account();
        account.setMoney(num);
        account.setProfileID(profileID);
        return sqlSession.update(namespace + "." + sqlID, account);
    }
    
}
