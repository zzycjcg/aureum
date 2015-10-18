package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.resource.message.LogoutResponse;
import com.brave.backend.util.SessionHolder;

/**
 * The Class LogoutService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class LogoutService
{
    private static LogoutService instance;
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(LogoutService instance)
    {
        LogoutService.instance = instance;
    }
    
    /**
     * Gets the single instance of LogoutService.
     *
     * @return single instance of LogoutService
     */
    public static LogoutService getInstance()
    {
        if (instance == null)
        {
            synchronized (LogoutService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(LogoutService.class);
                }
            }
        }
        return instance;
        
    }
    
    /**
     * Execute.
     *
     * @return the logout response
     */
    public LogoutResponse execute()
    {
        SessionHolder.getSession().invalidate();
        LogoutResponse response = new LogoutResponse();
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
