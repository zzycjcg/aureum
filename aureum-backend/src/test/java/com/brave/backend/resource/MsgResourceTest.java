package com.brave.backend.resource;

import java.util.ArrayList;
import java.util.List;

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
import com.brave.backend.dao.MsgDao;
import com.brave.backend.dao.SeqGenDao;
import com.brave.backend.dao.UserDao;
import com.brave.backend.resource.message.CheckAccountExistanceRequest;
import com.brave.backend.resource.message.CheckAccountExistanceResponse;
import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;
import com.brave.backend.resource.message.data.Content;
import com.brave.backend.util.SessionHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-beans.xml", "classpath:spring/backend.restserver.*.xml"})
public class MsgResourceTest
{
    @Resource
    private MsgResource msgResource;
    
    @Resource
    private UserResource userResource;
    
    @Resource
    private SeqGenDao seqGenDao;
    
    @Resource
    private MsgDao msgDao;
    
    @Resource
    private UserDao userDao;
    
    private RegisterRequest registerRequest;
    
    private String uid;
    
    private final String email = "zzycjcg@qq.com";
    
    private final String accountName = email;
    
    private final String password = "abcd1234";
    
    private final String username = "zzycjcg";
    
    private String msgId;
    
    /**
     * Prepare.
     */
    @Before
    public void prepare()
    {
        registerRequest = new RegisterRequest();
        registerRequest.setUsername(username);
        registerRequest.setEmail(email);
        registerRequest.setMobilePhone("18260082239");
        registerRequest.setPassword(password);
        registerRequest.setBrief("Hello, this is zhiyong zhu.");
        doRegister();
        doLogin();
    }
    
    @Test
    public void testPublishMsg()
    {
        doPublishMsg();
    }
    
    @Test
    public void testDeleteMsg()
    {
        doPublishMsg();
        doDeleteMsg();
    }
    
    private void doPublishMsg()
    {
        Content content = new Content();
        content.setText("Hi! This my first msg. Welcome to brave msg-sys.");
        List<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://www.baidu.com/img/bdlogo.png");
        imageUrls.add("https://upload.wikimedia.org/wikipedia/en/d/de/Alibaba_Group_Logo.png");
        content.setImageUrls(imageUrls);
        PublishMsgRequest request = new PublishMsgRequest();
        request.setContent(content);
        PublishMsgResponse response = msgResource.publish(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        Assert.assertTrue(StringUtils.isNotEmpty(msgId = response.getMsgId()));
    }
    
    private void doDeleteMsg()
    {
        List<String> msgIds = new ArrayList<String>();
        msgIds.add(msgId);
        DeleteMsgRequest request = new DeleteMsgRequest();
        request.setMsgIds(msgIds);
        DeleteMsgResponse response = msgResource.delete(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
    }
    
    private void doRegister()
    {
        String email = genAvaiableEmail();
        if (exists(email))
        {
            return;
        }
        registerRequest.setEmail(email);
        RegisterResponse registerResponse = userResource.register(registerRequest);
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(uid = registerResponse.getUid()));
        Assert.assertEquals(ReturnCodes.E0000, registerResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, registerResponse.getResultMessage());
    }
    
    private String genAvaiableEmail()
    {
        int index = 1;
        String email = this.email;
        while (exists(email))
        {
            email = username + String.valueOf(index++) + "@qq.com";
        }
        return email;
    }
    
    private boolean exists(String email)
    {
        CheckAccountExistanceRequest request = new CheckAccountExistanceRequest();
        request.setAccountName(email);
        CheckAccountExistanceResponse checkAccountExistanceResponse = userResource.checkAccountNameExistance(request);
        Assert.assertTrue(checkAccountExistanceResponse != null);
        Assert.assertTrue(checkAccountExistanceResponse != null);
        Assert.assertEquals(ReturnCodes.E0000, checkAccountExistanceResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, checkAccountExistanceResponse.getResultMessage());
        return checkAccountExistanceResponse.isExist();
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
        
        if (msgId == null)
        {
            return;
        }
        msgDao.delete(msgId);
        msgId = null;
    }
}
