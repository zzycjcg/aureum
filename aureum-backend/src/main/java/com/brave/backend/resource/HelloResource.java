/*
 * 文 件 名:  HelloReource.java
 * 版    权:  Copyright 2013-2015,  All rights reserved
 * 描    述:  <描述>
 */
package com.brave.backend.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <一句话功能简述>
 * 
 * @author brave
 * @version [v1, 2015年6月14日]
 */
@Path("hello")
public interface HelloResource
{
    @GET
    @Path("say")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> sayHello();
}
