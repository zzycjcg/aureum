package com.brave.backend.dao;

import com.brave.backend.dao.model.Account;
import com.brave.foundation.dao.BaseDao;

/**
 * The Interface AccountDao.
 */
public interface AccountDao extends BaseDao<Account>
{
    Account queryByAccountName(String accountName);
}
