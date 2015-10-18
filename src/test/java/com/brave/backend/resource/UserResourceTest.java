package com.brave.backend.resource;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.resource.message.CheckAccountExistanceRequest;
import com.brave.backend.resource.message.CheckAccountExistanceResponse;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.resource.message.LogoutResponse;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;
import com.brave.backend.util.SessionHolder;

/**
 * The Class UserResourceTest.
 *
 * @author zhiyong zhu at 2015-10-10
 * @since v0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:META-INF/spring/spring-beans.xml", "classpath*:spring/backend.restserver.*.xml",
    "classpath*:spring/test.*.xml"})
@Transactional
public class UserResourceTest
{
    @Autowired
    private UserResource userResource;
    
    private static RegisterRequest registerRequest;
    
    private static final String email = "zzycjcg@qq.com";
    
    private static final String accountName = email;
    
    private static final String password = "abcd1234";
    
    private static final String username = "zzycjcg";
    
    /**
     * Prepare.
     */
    @BeforeClass
    public static void init()
    {
        registerRequest = new RegisterRequest();
        registerRequest.setUsername(username);
        registerRequest.setEmail(email);
        registerRequest.setMobilePhone("18260082239");
        registerRequest.setPassword(password);
        registerRequest.setBrief("Hello, this is zhiyong zhu.");
    }
    
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
    
    private void doLogin()
    {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(accountName);
        loginRequest.setPassword(password);
        HttpSession httpSession = new MockHttpSession();
        SessionHolder.setSession(httpSession);
        LoginResponse loginResponse = userResource.login(loginRequest);
        Assert.assertTrue(loginResponse != null && StringUtils.isNotEmpty(loginResponse.getUid()));
        Assert.assertEquals(ReturnCodes.E0000, loginResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, loginResponse.getResultMessage());
    }
    
    private void doRegister()
    {
        RegisterResponse registerResponse = userResource.register(registerRequest);
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(registerResponse.getUid()));
        Assert.assertEquals(ReturnCodes.E0000, registerResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, registerResponse.getResultMessage());
    }
    
    private void doLogout()
    {
        LogoutResponse logoutResponse = userResource.logout();
        Assert.assertTrue(logoutResponse != null);
        Assert.assertEquals(ReturnCodes.E0000, logoutResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, logoutResponse.getResultMessage());
    }
    
    private void doCheckAccountNameExistance()
    {
        CheckAccountExistanceRequest request = new CheckAccountExistanceRequest();
        request.setAccountName(accountName);
        CheckAccountExistanceResponse response = userResource.checkAccountNameExistance(request);
        Assert.assertTrue(response != null && response.isExist());
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
    }
}