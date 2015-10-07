package com.brave.backend.resource.message;

import java.util.List;

import com.brave.backend.dao.model.MsgWithContent;

/**
 * The Class QueryMsgResponse.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class QueryMsgResponse extends CommonResponse
{
    private List<MsgWithContent> msgs;
    
    private int totalPages;
    
    private int count;
    
    /**
     * Gets the msgs.
     *
     * @return the msgs
     */
    public List<MsgWithContent> getMsgs()
    {
        return msgs;
    }
    
    /**
     * Sets the msgs.
     *
     * @param msgs the new msgs
     */
    public void setMsgs(List<MsgWithContent> msgs)
    {
        this.msgs = msgs;
    }
    
    /**
     * Gets the total pages.
     *
     * @return the total pages
     */
    public int getTotalPages()
    {
        return totalPages;
    }
    
    /**
     * Sets the total pages.
     *
     * @param totalPages the new total pages
     */
    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }
    
    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount()
    {
        return count;
    }
    
    /**
     * Sets the count.
     *
     * @param count the new count
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryMsgResponse [msgs=");
        builder.append(msgs);
        builder.append(", totalPages=");
        builder.append(totalPages);
        builder.append(", count=");
        builder.append(count);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
