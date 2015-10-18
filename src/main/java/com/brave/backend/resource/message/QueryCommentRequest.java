package com.brave.backend.resource.message;

/**
 * The Class QueryCommentRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class QueryCommentRequest extends CommonRequest
{
    /** 指定的消息，必选. */
    private String msgId;
    
    /** The page. */
    private int page;
    
    /** The num per page. */
    private int numPerPage;
    
    /** 指定用户，为空时查询全部用户. */
    private String uid;
    
    /** 是否逆序，默认根据时间逆序排列. */
    private boolean desc = true;
    
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
     * Gets the page.
     *
     * @return the page
     */
    public int getPage()
    {
        return page;
    }
    
    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(int page)
    {
        this.page = page;
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
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryCommentRequest [msgId=");
        builder.append(msgId);
        builder.append(", page=");
        builder.append(page);
        builder.append(", numPerPage=");
        builder.append(numPerPage);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", desc=");
        builder.append(desc);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
