package com.brave.backend.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * The Class JsonUtil.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public abstract class JsonUtil
{
    
    /**
     * To json.
     *
     * @param object the object
     * @return the string
     */
    public static String toJson(Object object)
    {
        return JSON.toJSONString(object);
    }
    
    /**
     * Parses the json string.
     *
     * @param <T> the generic type
     * @param json the json
     * @return the t
     */
    public static <T> T parseJsonString(String json)
    {
        return JSON.parseObject(json, new TypeReference<T>()
        {
        });
    }
}
