package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.constant.SessionKeys;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.AccountDao;
import com.brave.backend.dao.UserDao;
import com.brave.backend.dao.model.Account;
import com.brave.backend.dao.model.User;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.util.SessionHolder;

/**
 * The Class LoginService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class LoginService
{
    private AccountDao accountDao;
    
    private UserDao userDao;
    
    private static LoginService instance;
    
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
     * Sets the user dao.
     *
     * @param userDao the new user dao
     */
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(LoginService instance)
    {
        LoginService.instance = instance;
    }
    
    /**
     * Gets the single instance of LoginService.
     *
     * @return single instance of LoginService
     */
    public static LoginService getInstance()
    {
        if (instance == null)
        {
            synchronized (LoginService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(LoginService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Execute.
     *
     * @param loginRequest the login request
     * @return the login response
     */
    public LoginResponse execute(LoginRequest loginRequest)
    {
        LoginResponse response = new LoginResponse();
        Account account = accountDao.queryByAccountName(loginRequest.getUsername());
        if (account == null)
        {
            response.setResultCode(ReturnCodes.E1001);
            response.setResultMessage(ReturnMessages.E1001);
            return response;
        }
        // TODO 密码加密
        User user = userDao.verifyUserPassword(account.getUid(), loginRequest.getPassword());
        if (user == null)
        {
            response.setResultCode(ReturnCodes.E1002);
            response.setResultMessage(ReturnMessages.E1001);
            return response;
        }
        SessionHolder.getSession().setAttribute(SessionKeys.UID, account.getUid());
        response.setUid(account.getUid());
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
