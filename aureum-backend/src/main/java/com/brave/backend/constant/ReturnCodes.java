package com.brave.backend.constant;

/**
 * The Interface ReturnCodes.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface ReturnCodes
{
    
    /** Success. */
    String E0000 = "0000";
    
    /** 账户不存在. */
    String E1001 = "1001";
    
    /** 用户密码不正确. */
    String E1002 = "1002";
    
    /** 用户不存在(UID不存在). */
    String E1003 = "1003";
    
    /** 用户未登录. */
    String E1004 = "1004";
    
    /** 数据库操作失败. */
    String E9001 = "9001";
    
    /** 未知错误. */
    String E9999 = "9999";
    
}
