package com.brave.backend.dao.model;

/**
 * The Class CommentQueryCondition.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class CommentQueryCondition
{
    private int start;
    
    private int numPerPage;
    
    /** 根据添加时间逆序. */
    private boolean desc;
    
    /** 显示指定用户的评论. */
    private String uid;
    
    /** 评论的消息. */
    private String msgId;
    
    /**
     * Gets the start.
     *
     * @return the start
     */
    public int getStart()
    {
        return start;
    }
    
    /**
     * Sets the start.
     *
     * @param start the new start
     */
    public void setStart(int start)
    {
        this.start = start;
    }
    
    /**
     * Gets the num per page.
     *
     * @return the num per page
     */
    public int getNumPerPage()
    {
        return numPerPage;
    }
    
    /**
     * Sets the num per page.
     *
     * @param numPerPage the new num per page
     */
    public void setNumPerPage(int numPerPage)
    {
        this.numPerPage = numPerPage;
    }
    
    /**
     * Checks if is desc.
     *
     * @return true, if is desc
     */
    public boolean isDesc()
    {
        return desc;
    }
    
    /**
     * Sets the desc.
     *
     * @param desc the new desc
     */
    public void setDesc(boolean desc)
    {
        this.desc = desc;
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
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CommentQueryCondition [start=");
        builder.append(start);
        builder.append(", numPerPage=");
        builder.append(numPerPage);
        builder.append(", desc=");
        builder.append(desc);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", msgId=");
        builder.append(msgId);
        builder.append("]");
        return builder.toString();
    }
    
}
