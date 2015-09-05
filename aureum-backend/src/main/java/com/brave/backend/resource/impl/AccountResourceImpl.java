package com.brave.backend.resource.impl;

import com.brave.backend.dao.AccountDao;
import com.brave.backend.resource.AccountResource;

public class AccountResourceImpl implements AccountResource
{
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String out, String in, double num)
	{
		// int r = accountDao.deductMoney(out, num);
		// if (r > 0)
		// {
		// throw new RuntimeException();
		// }
		accountDao.deductMoney(out, num);
		accountDao.addMoney(in, num);
	}

}
