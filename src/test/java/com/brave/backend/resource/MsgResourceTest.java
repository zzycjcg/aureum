package com.brave.backend.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
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
import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.QueryMsgRequest;
import com.brave.backend.resource.message.QueryMsgResponse;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;
import com.brave.backend.resource.message.data.Content;
import com.brave.backend.util.SessionHolder;

/**
 * The Class MsgResourceTest.
 *
 * @author zhiyong zhu at 2015-10-16
 * @since v0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:META-INF/spring/spring-beans.xml", "classpath*:spring/backend.restserver.*.xml",
    "classpath*:spring/test.*.xml"})
@Transactional
public class MsgResourceTest
{
    @Autowired
    private MsgResource msgResource;
    
    @Autowired
    private UserResource userResource;
    
    private static RegisterRequest registerRequest;
    
    private String uid;
    
    private static final String email = "zzycjcg@qq.com";
    
    private static final String accountName = email;
    
    private static final String password = "abcd1234";
    
    private static final String username = "zzycjcg";
    
    private final Map<Integer, String> msgIdMap = new HashMap<Integer, String>();
    
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
     * Prepare.
     */
    @Before
    public void prepare()
    {
        doRegister();
        doLogin();
    }
    
    /**
     * Test publish msg.
     */
    @Test
    public void testPublishMsg()
    {
        doPublishMsg(0);
        doDeleteMsg();
    }
    
    /**
     * Test delete msg.
     */
    @Test
    public void testDeleteMsg()
    {
        doPublishMsg(0);
        doDeleteMsg();
    }
    
    /**
     * Test query msg.
     */
    @Test
    public void testQueryMsg()
    {
        doQueryMsg();
        doDeleteMsg();
    }
    
    private void doPublishMsg(int index)
    {
        Content content = new Content();
        content.setText("[msg" + String.valueOf(index) + "]Hi! This my first msg. Welcome to brave msg-sys.");
        List<String> imageUrls = new ArrayList<String>();
        imageUrls.add("[msg" + String.valueOf(index) + "]http://www.baidu.com/img/bdlogo.png");
        imageUrls.add(
            "[msg" + String.valueOf(index) + "]https://upload.wikimedia.org/wikipedia/en/d/de/Alibaba_Group_Logo.png");
        content.setImageUrls(imageUrls);
        PublishMsgRequest request = new PublishMsgRequest();
        request.setContent(content);
        PublishMsgResponse response = msgResource.publish(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        String msgId = null;
        Assert.assertTrue(StringUtils.isNotEmpty(msgId = response.getMsgId()));
        msgIdMap.put(index, msgId);
    }
    
    private void doDeleteMsg()
    {
        List<String> msgIds = new ArrayList<String>();
        msgIds.addAll(msgIdMap.values());
        DeleteMsgRequest request = new DeleteMsgRequest();
        request.setMsgIds(msgIds);
        DeleteMsgResponse response = msgResource.delete(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        msgIdMap.clear();
    }
    
    private void doQueryMsg()
    {
        int count = 5;
        // 发布5条消息
        for (int i = 0; i < count; i++)
        {
            doPublishMsg(i);
            try
            {
                // 每隔2s发布一条消息
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        QueryMsgRequest request = new QueryMsgRequest();
        request.setDesc(true);
        request.setNumPerPage(10);
        request.setPage(1);
        request.setUid(uid);
        QueryMsgResponse response = msgResource.query(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        Assert.assertTrue(response.getCount() == count);
        for (int i = 0; i < count; i++)
        {
            Assert.assertEquals(msgIdMap.get(count - 1 - i), response.getMsgs().get(i).getMsgId());
        }
    }
    
    private void doRegister()
    {
        RegisterResponse registerResponse = userResource.register(registerRequest);
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(uid = registerResponse.getUid()));
        Assert.assertEquals(ReturnCodes.E0000, registerResponse.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, registerResponse.getResultMessage());
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
}
