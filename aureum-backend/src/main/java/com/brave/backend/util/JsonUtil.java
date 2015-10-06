package com.brave.backend.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public abstract class JsonUtil
{
    public static String toJson(Object object)
    {
        return JSON.toJSONString(object);
    }
    
    public static <T> T parseJsonString(String json)
    {
        return JSON.parseObject(json, new TypeReference<T>()
        {
        });
    }
}
