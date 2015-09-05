package com.brave.backend.dao;

import com.brave.backend.dao.model.Account;
import com.brave.foundation.dao.BaseDao;

/**
 * The Interface AccountDao.
 */
public interface AccountDao extends BaseDao<Account>
{
    
    /**
     * Adds the money.
     *
     * @param profileID the profile id
     * @param num the num
     * @return the int
     */
    int addMoney(String profileID, double num);
    
    /**
     * Deduct money.
     *
     * @param profileID the profile id
     * @param num the num
     * @return the int
     */
    int deductMoney(String profileID, double num);
}
