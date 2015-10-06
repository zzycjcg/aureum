package com.brave.backend.resource.message;

import java.util.List;

public class DeleteMsgRequest extends CommonRequest
{
    private List<String> msgIds;
    
    public List<String> getMsgIds()
    {
        return msgIds;
    }
    
    public void setMsgIds(List<String> msgIds)
    {
        this.msgIds = msgIds;
    }
    
    @Override
    public String toString()
    {
        return "DeleteMsgRequest [msgIds=" + msgIds + "]";
    }
    
}
