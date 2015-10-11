package com.brave.backend.resource;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.constant.SeqIds;
import com.brave.backend.dao.SeqGenDao;
import com.brave.backend.dao.UserDao;
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
@ContextConfiguration({"classpath:spring/spring-beans.xml", "classpath:spring/backend.restserver.*.xml"})
public class UserResourceTest
{
    @Resource
    private UserResource userResource;
    
    @Resource
    private UserDao userDao;
    
    @Resource
    private SeqGenDao seqGenDao;
    
    private RegisterRequest registerRequest;
    
    private String uid;
    
    private final String email = "zzycjcg@qq.com";
    
    private final String accountName = email;
    
    private final String password = "abcd1234";
    
    /**
     * Prepare.
     */
    @Before
    public void prepare()
    {
        registerRequest = new RegisterRequest();
        registerRequest.setUsername("zzycjcg");
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
    
    /**
     * Clean.
     */
    @After
    public void clean()
    {
        if (uid == null)
        {
            return;
        }
        userDao.delete(uid);
        seqGenDao.setVal(SeqIds.SEQ_UID, "0");
        uid = null;
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
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(uid = registerResponse.getUid()));
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
