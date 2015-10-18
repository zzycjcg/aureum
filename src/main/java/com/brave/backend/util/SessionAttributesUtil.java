package com.brave.backend.util;

import com.brave.backend.constant.SessionKeys;

/**
 * The Class SessionAttributesUtil.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public abstract class SessionAttributesUtil
{
    /**
     * 获取当前登录用户uid
     *
     * @return the uid
     */
    public static String getUid()
    {
        return (String)SessionHolder.getSession().getAttribute(SessionKeys.UID);
    }
    
}
