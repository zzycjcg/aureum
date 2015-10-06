package com.brave.backend.resource.message.data;

/**
 * The Class Comment.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class Comment
{
    private String msgId;
    
    private Content content;
    
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
     * Gets the content.
     *
     * @return the content
     */
    public Content getContent()
    {
        return content;
    }
    
    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(Content content)
    {
        this.content = content;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [msgId=");
        builder.append(msgId);
        builder.append(", content=");
        builder.append(content);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
