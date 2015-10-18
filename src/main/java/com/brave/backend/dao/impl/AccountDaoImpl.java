package com.brave.backend.dao.impl;

import com.brave.backend.dao.AccountDao;
import com.brave.backend.dao.model.Account;
import com.github.zzycjcg.foundation.dao.impl.BaseDaoImpl;

/**
 * The Class AccountDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao
{
    /** {@inheritDoc} */
    
    @Override
    public Account queryByAccountName(String accountName)
    {
        return sqlSession.selectOne(namespace + ".queryByAccountName", accountName);
    }
}
