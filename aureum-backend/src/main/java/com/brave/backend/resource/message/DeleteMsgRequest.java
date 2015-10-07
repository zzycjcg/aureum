package com.brave.backend.resource.message;

import java.util.List;

/**
 * The Class DeleteMsgRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class DeleteMsgRequest extends CommonRequest
{
    private List<String> msgIds;
    
    /**
     * Gets the msg ids.
     *
     * @return the msg ids
     */
    public List<String> getMsgIds()
    {
        return msgIds;
    }
    
    /**
     * Sets the msg ids.
     *
     * @param msgIds the new msg ids
     */
    public void setMsgIds(List<String> msgIds)
    {
        this.msgIds = msgIds;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DeleteMsgRequest [msgIds=");
        builder.append(msgIds);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
