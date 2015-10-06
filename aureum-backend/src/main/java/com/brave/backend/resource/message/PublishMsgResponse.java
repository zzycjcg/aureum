package com.brave.backend.resource.message;

public class PublishMsgResponse extends CommonResponse
{
    private String msgId;
    
    public String getMsgId()
    {
        return msgId;
    }
    
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PublishMsgResponse [msgId=");
        builder.append(msgId);
        builder.append("]");
        return builder.toString();
    }
    
}
