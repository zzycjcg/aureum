package com.brave.backend.resource;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
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
 * The Class UserBasedAbstractTest.
 *
 * @author zhiyong zhu at 2015-10-18
 * @since v0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:META-INF/spring/spring-beans.xml", "classpath*:spring/backend.restserver.*.xml",
    "classpath*:spring/test.*.xml"})
@Transactional
public abstract class UserBasedAbstractTest
{
    
    /** The user resource. */
    @Autowired
    protected UserResource userResource;
    
    /** The register request. */
    protected static RegisterRequest registerRequest;
    
    /** The Constant email. */
    protected static final String email = "zzycjcg@qq.com";
    
    /** The Constant accountName. */
    protected static final String accountName = email;
    
    /** The Constant password. */
    protected static final String password = "abcd1234";
    
    /** The Constant username. */
    protected static final String username = "zzycjcg";
    
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
     * Do login.
     */
    protected void doLogin()
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
    
    /**
     * Do register.
     */
    protected void doRegister()
    {
        RegisterResponse registerResponse = userResource.register(registerRequest);
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(registerResponse.getUid()));
        Assert.assertEquals(ReturnCodes.E0000, registerResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, registerResponse.getResultMessage());
    }
    
    /**
     * Do logout.
     */
    protected void doLogout()
    {
        LogoutResponse logoutResponse = userResource.logout();
        Assert.assertTrue(logoutResponse != null);
        Assert.assertEquals(ReturnCodes.E0000, logoutResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, logoutResponse.getResultMessage());
    }
    
    /**
     * Do check account name existance.
     */
    protected void doCheckAccountNameExistance()
    {
        CheckAccountExistanceRequest request = new CheckAccountExistanceRequest();
        request.setAccountName(accountName);
        CheckAccountExistanceResponse response = userResource.checkAccountNameExistance(request);
        Assert.assertTrue(response != null && response.isExist());
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
    }
}
