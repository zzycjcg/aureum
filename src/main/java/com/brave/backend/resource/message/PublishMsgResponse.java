package com.brave.backend.resource.message;

/**
 * The Class PublishMsgResponse.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class PublishMsgResponse extends CommonResponse
{
    private String msgId;
    
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
        builder.append("PublishMsgResponse [msgId=");
        builder.append(msgId);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
