package com.brave.backend.resource.message;

import com.brave.backend.resource.message.data.Content;

/**
 * The Class PublishMsgRequest.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class PublishMsgRequest extends CommonRequest
{
    private Content content;
    
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
        builder.append("PublishMsgRequest [content=");
        builder.append(content);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
