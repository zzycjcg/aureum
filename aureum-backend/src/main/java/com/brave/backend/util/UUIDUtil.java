package com.brave.backend.util;

import java.util.UUID;

/**
 * The Class UUIDUtil.
 */
public abstract class UUIDUtil
{
    
    /**
     * Generate uuid.
     *
     * @return the string
     */
    private static String generateUUID()
    {
        return UUID.randomUUID().toString();
    }
    
    /**
     * Generate profile id.
     *
     * @return the profile id
     */
    public static String generateProfileId()
    {
        return generateUUID();
    }
    
    /**
     * Generate account id.
     *
     * @return the string
     */
    public static String generateAccountId()
    {
        return generateUUID();
    }
    
    /**
     * Generate content id.
     *
     * @return the string
     */
    public static String generateContentId()
    {
        return generateUUID();
    }
    
    /**
     * Generate msg id.
     *
     * @return the string
     */
    public static String generateMsgId()
    {
        return generateUUID();
    }
    
    /**
     * Generate comment id.
     *
     * @return the string
     */
    public static String generateCommentId()
    {
        return generateUUID();
    }
}
