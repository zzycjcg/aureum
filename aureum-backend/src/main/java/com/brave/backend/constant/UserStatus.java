package com.brave.backend.constant;

/**
 * The Interface UserStatus.
 */
public interface UserStatus
{
    /** 正常. */
    char NORMAL = '1';
    
    /** 删除中. */
    char DELETING = '2';
    
    /** 锁定. */
    char LOCKED = '3';
    
    /** 未激活. */
    char UNACTIVATED = '4';
}