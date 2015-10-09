package com.brave.backend.resource;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.constant.SeqIds;
import com.brave.backend.dao.SeqGenDao;
import com.brave.backend.dao.UserDao;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;

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
    
    /**
     * Prepare.
     */
    @Before
    public void prepare()
    {
        registerRequest = new RegisterRequest();
        registerRequest.setUsername("zzycjcg");
        registerRequest.setEmail("zzycjcg@qq.com");
        registerRequest.setMobilePhone("18260082239");
        registerRequest.setPassword("abcd1234");
        registerRequest.setBrief("Hello, this is zhiyong zhu.");
    }
    
    /**
     * Test register.
     */
    @Test
    public void testRegister()
    {
        RegisterResponse registerResponse = userResource.register(registerRequest);
        Assert.assertTrue(registerResponse != null && StringUtils.isNotEmpty(uid = registerResponse.getUid()));
        Assert.assertEquals(registerResponse.getResultCode(), ReturnCodes.E0000);
        Assert.assertEquals(registerResponse.getResultMessage(), ReturnMessages.E0000);
    }
    
    /**
     * Clean.
     */
    @After
    public void clean()
    {
        userDao.delete(uid);
        seqGenDao.setVal(SeqIds.SEQ_UID, "0");
    }
}
