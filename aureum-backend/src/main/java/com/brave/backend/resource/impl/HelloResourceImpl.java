/*
 * 文 件 名:  HelloResourceImpl.java
 * 版    权:  Copyright 2013-2015,  All rights reserved
 * 描    述:  <描述>
 */
package com.brave.backend.resource.impl;

import java.util.HashMap;
import java.util.Map;

import com.brave.backend.resource.HelloResource;

/**
 * <一句话功能简述>
 * 
 * @author  brave
 * @version  [v1, 2015年6月14日]
 */
public class HelloResourceImpl implements HelloResource
{
    
    /** {@inheritDoc} */
    
    @Override
    public Map<String, Object> sayHello()
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("say", "hello");
        return result;
    }
    
}
