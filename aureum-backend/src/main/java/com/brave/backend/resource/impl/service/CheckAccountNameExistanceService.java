package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.AccountDao;
import com.brave.backend.dao.model.Account;
import com.brave.backend.resource.message.CheckAccountExistanceRequest;
import com.brave.backend.resource.message.CheckAccountExistanceResponse;

/**
 * The Class CheckAccountNameExistanceService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CheckAccountNameExistanceService
{
    /** The account dao. */
    private AccountDao accountDao;
    
    private static CheckAccountNameExistanceService instance;
    
    /**
     * Sets the account dao.
     *
     * @param accountDao the new account dao
     */
    public void setAccountDao(AccountDao accountDao)
    {
        this.accountDao = accountDao;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(CheckAccountNameExistanceService instance)
    {
        CheckAccountNameExistanceService.instance = instance;
    }
    
    /**
     * Gets the instace.
     *
     * @return the instace
     */
    public static CheckAccountNameExistanceService getInstace()
    {
        if (instance == null)
        {
            synchronized (CheckAccountNameExistanceService.class)
            {
                if (instance == null)
                {
                    instance = ApplicationContextHolder.getInstance()
                        .getApplicationContext()
                        .getBean(CheckAccountNameExistanceService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Execute.
     *
     * @param checkAccountRequest the check account request
     * @return the check account existance response
     */
    public CheckAccountExistanceResponse execute(CheckAccountExistanceRequest checkAccountRequest)
    {
        Account account = accountDao.queryByAccountName(checkAccountRequest.getAccountName());
        CheckAccountExistanceResponse response = new CheckAccountExistanceResponse();
        response.setExist(account != null);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
