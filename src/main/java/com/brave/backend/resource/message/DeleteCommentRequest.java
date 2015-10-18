package com.brave.backend.resource.message;

import java.util.List;

/**
 * The Class DeleteCommentRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class DeleteCommentRequest extends CommonRequest
{
    private List<String> commentIds;
    
    /**
     * Gets the comment ids.
     *
     * @return the comment ids
     */
    public List<String> getCommentIds()
    {
        return commentIds;
    }
    
    /**
     * Sets the comment ids.
     *
     * @param commentIds the new comment ids
     */
    public void setCommentIds(List<String> commentIds)
    {
        this.commentIds = commentIds;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DeleteCommentRequest [commentIds=");
        builder.append(commentIds);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
