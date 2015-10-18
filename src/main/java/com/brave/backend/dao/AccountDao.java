package com.brave.backend.dao;

import com.brave.backend.dao.model.Account;
import com.github.zzycjcg.foundation.dao.BaseDao;

/**
 * The Interface AccountDao.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface AccountDao extends BaseDao<Account>
{
    /**
     * Query by account name.
     *
     * @param accountName the account name
     * @return the account
     */
    Account queryByAccountName(String accountName);
}
