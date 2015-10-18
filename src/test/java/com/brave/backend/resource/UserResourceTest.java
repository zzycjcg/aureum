package com.brave.backend.resource;

import org.junit.Test;

/**
 * The Class UserResourceTest.
 *
 * @author zhiyong zhu at 2015-10-10
 * @since v0.0.1
 */
public class UserResourceTest extends UserBasedAbstractTest
{
    /**
     * Test register.
     */
    @Test
    public void testRegister()
    {
        doRegister();
    }
    
    /**
     * Test login.
     */
    @Test
    public void testLogin()
    {
        // 登录前先注册
        doRegister();
        doLogin();
    }
    
    /**
     * Test logout.
     */
    @Test
    public void testLogout()
    {
        // 登录前先注册
        doRegister();
        doLogin();
        doLogout();
    }
    
    /**
     * Test check account name existance.
     */
    @Test
    public void testCheckAccountNameExistance()
    {
        // 登录前先注册
        doRegister();
        doCheckAccountNameExistance();
    }
}
