package com.brave.backend.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

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
     * Parses the object.
     *
     * @param <T> the generic type
     * @param json the json
     * @param clazz the clazz
     * @return the t
     */
    public static <T> T parseObject(String json, Class<T> clazz)
    {
        return JSON.parseObject(json, clazz);
    }
    
    /**
     * Parses the array.
     *
     * @param <T> the generic type
     * @param json the json
     * @param clazz the clazz
     * @return the list
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz)
    {
        return JSON.parseArray(json, clazz);
    }
}
