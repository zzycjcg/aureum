package com.brave.backend.resource;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-beans.xml", "classpath:spring/backend.restserver.*.xml" })
public class HelloResourceTest
{
	@Resource(name = "backend.resource.HelloResource")
	private HelloResource helloResource;

	@Test
	public void testSayHello()
	{
		Map<String, Object> result = helloResource.sayHello();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.get("say"), "hello");
	}
}
