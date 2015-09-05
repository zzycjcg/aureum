package com.brave.backend.resource;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-beans.xml", "classpath:spring/backend.restserver.*.xml"})
public class AccountResourceTest
{
    @Resource(name = "backend.resource.AccountResource")
    private AccountResource accountResource;
    
    @Test
    public void transfer()
    {
        accountResource.transfer("aaa", "bbb", 200D);
    }
}
