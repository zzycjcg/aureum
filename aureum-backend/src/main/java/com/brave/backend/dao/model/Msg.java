package com.brave.backend.dao.model;

/**
 * The Class Msg.
 */
public class Msg
{
    
    /** The msg id. */
    protected String msgId;
    
    /** The content id. */
    protected String contentId;
    
    /** The uid. */
    protected String uid;
    
    /** The create time. */
    protected String createTime;
    
    /** The update time. */
    protected String updateTime;
    
    /**
     * Gets the msg id.
     *
     * @return the msg id
     */
    public String getMsgId()
    {
        return msgId;
    }
    
    /**
     * Sets the msg id.
     *
     * @param msgId the new msg id
     */
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }
    
    /**
     * Gets the content id.
     *
     * @return the content id
     */
    public String getContentId()
    {
        return contentId;
    }
    
    /**
     * Sets the content id.
     *
     * @param contentId the new content id
     */
    public void setContentId(String contentId)
    {
        this.contentId = contentId;
    }
    
    /**
     * Gets the uid.
     *
     * @return the uid
     */
    public String getUid()
    {
        return uid;
    }
    
    /**
     * Sets the uid.
     *
     * @param uid the new uid
     */
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    
    /**
     * Gets the creates the time.
     *
     * @return the creates the time
     */
    public String getCreateTime()
    {
        return createTime;
    }
    
    /**
     * Sets the creates the time.
     *
     * @param createTime the new creates the time
     */
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    /**
     * Gets the update time.
     *
     * @return the update time
     */
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    /**
     * Sets the update time.
     *
     * @param updateTime the new update time
     */
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Msg [msgId=");
        builder.append(msgId);
        builder.append(", contentId=");
        builder.append(contentId);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append("]");
        return builder.toString();
    }
    
}
