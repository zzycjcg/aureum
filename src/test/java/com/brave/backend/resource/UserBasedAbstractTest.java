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
    
    /** The uid. */
    protected String uid;
    
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
        LoginResponse response = userResource.login(loginRequest);
        AssertUtil.assertResponseValid(response);
        Assert.assertTrue(StringUtils.isNotEmpty(response.getUid()));
    }
    
    /**
     * Do register.
     */
    protected void doRegister()
    {
        RegisterResponse response = userResource.register(registerRequest);
        AssertUtil.assertResponseValid(response);
        Assert.assertTrue(StringUtils.isNotEmpty(uid = response.getUid()));
    }
    
    /**
     * Do logout.
     */
    protected void doLogout()
    {
        LogoutResponse response = userResource.logout();
        AssertUtil.assertResponseValid(response);
    }
    
    /**
     * Do check account name existance.
     *
     * @param accountName the account name
     */
    protected void doCheckAccountNameExistance(String accountName)
    {
        CheckAccountExistanceRequest request = new CheckAccountExistanceRequest();
        request.setAccountName(accountName);
        CheckAccountExistanceResponse response = userResource.checkAccountNameExistance(request);
        AssertUtil.assertResponseValid(response);
        Assert.assertTrue(response.isExist());
    }
}
