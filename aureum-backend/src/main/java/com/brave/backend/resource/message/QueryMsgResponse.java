package com.brave.backend.resource.message;

import java.util.List;

import com.brave.backend.dao.model.MsgWithContent;

public class QueryMsgResponse extends CommonResponse
{
    private List<MsgWithContent> msgs;
    
    private int totalPages;
    
    private int count;
    
    public List<MsgWithContent> getMsgs()
    {
        return msgs;
    }
    
    public void setMsgs(List<MsgWithContent> msgs)
    {
        this.msgs = msgs;
    }
    
    public int getTotalPages()
    {
        return totalPages;
    }
    
    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
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
        builder.append("]");
        return builder.toString();
    }
    
}
