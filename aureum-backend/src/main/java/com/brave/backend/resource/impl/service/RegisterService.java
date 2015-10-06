package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.constant.UserStatus;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.AccountDao;
import com.brave.backend.dao.UserDao;
import com.brave.backend.dao.model.Account;
import com.brave.backend.dao.model.Profile;
import com.brave.backend.dao.model.User;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;
import com.brave.backend.util.JodaTimeUtil;
import com.brave.backend.util.JodaTimeUtil.DateFormats;
import com.brave.backend.util.UUIDUtil;
import com.brave.foundation.dao.BaseDao;

/**
 * The Class RegisterService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class RegisterService
{
    
    /** The account dao. */
    private AccountDao accountDao;
    
    /** The user dao. */
    private UserDao userDao;
    
    /** The profile dao. */
    private BaseDao<Profile> profileDao;
    
    private static RegisterService instance;
    
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
     * Sets the profile dao.
     *
     * @param profileDao the new profile dao
     */
    public void setProfileDao(BaseDao<Profile> profileDao)
    {
        this.profileDao = profileDao;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(RegisterService instance)
    {
        RegisterService.instance = instance;
    }
    
    /**
     * Gets the single instance of RegisterService.
     *
     * @return single instance of RegisterService
     */
    public static RegisterService getInstance()
    {
        if (instance == null)
        {
            synchronized (RegisterService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(RegisterService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Execute.
     *
     * @param registerRequest the register request
     * @return the register response
     */
    public RegisterResponse execute(RegisterRequest registerRequest)
    {
        String registerTime = JodaTimeUtil.getCurrentUTCTime(DateFormats.FORMAT_1);
        String profileId = UUIDUtil.generateProfileId();
        String accountId = UUIDUtil.generateAccountId();
        // TODO UID
        String uid = "1";
        // user data
        User user = new User();
        
        user.setUid(uid);
        user.setCreateTime(registerTime);
        // TODO 不可逆加密
        user.setPassword(registerRequest.getPassword());
        user.setStatus(UserStatus.NORMAL);
        user.setProfileId(profileId);
        
        // profile data
        Profile profile = new Profile();
        profile.setProfileId(profileId);
        profile.setEmail(registerRequest.getEmail());
        
        // account data
        Account account = new Account();
        account.setAccountId(accountId);
        account.setAccountName(registerRequest.getEmail());
        account.setUid(uid);
        operateDB(user, profile, account);
        RegisterResponse response = new RegisterResponse();
        response.setUid(uid);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
    
    /**
     * Operate db.
     *
     * @param user the user
     * @param profile the profile
     * @param account the account
     */
    // TODO 事务
    private void operateDB(User user, Profile profile, Account account)
    {
        profileDao.insert(profile);
        userDao.insert(user);
        accountDao.insert(account);
    }
    
}
