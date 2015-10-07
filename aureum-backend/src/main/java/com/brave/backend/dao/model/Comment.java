package com.brave.backend.dao.model;

/**
 * The Class Comment.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class Comment
{
    
    /** The comment id. */
    protected String commentId;
    
    /** The msg id. */
    protected String msgId;
    
    /** The uid. */
    protected String uid;
    
    /** The text. */
    protected String text;
    
    /** The multi media. */
    protected String multiMedia;
    
    /** The create time. */
    protected String createTime;
    
    /** The update time. */
    protected String updateTime;
    
    /**
     * Gets the comment id.
     *
     * @return the comment id
     */
    public String getCommentId()
    {
        return commentId;
    }
    
    /**
     * Sets the comment id.
     *
     * @param commentId the new comment id
     */
    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }
    
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
    
    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text)
    {
        this.text = text;
    }
    
    /**
     * Gets the multi media.
     *
     * @return the multi media
     */
    public String getMultiMedia()
    {
        return multiMedia;
    }
    
    /**
     * Sets the multi media.
     *
     * @param multiMedia the new multi media
     */
    public void setMultiMedia(String multiMedia)
    {
        this.multiMedia = multiMedia;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [commentId=");
        builder.append(commentId);
        builder.append(", msgId=");
        builder.append(msgId);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", text=");
        builder.append(text);
        builder.append(", multiMedia=");
        builder.append(multiMedia);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", updateTime=");
        builder.append(updateTime);
        builder.append("]");
        return builder.toString();
    }
}
