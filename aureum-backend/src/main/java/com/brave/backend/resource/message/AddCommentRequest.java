package com.brave.backend.resource.message;

import com.brave.backend.resource.message.data.Comment;

/**
 * The Class AddCommentRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class AddCommentRequest extends CommonRequest
{
    private Comment comment;
    
    /**
     * Gets the comment.
     *
     * @return the comment
     */
    public Comment getComment()
    {
        return comment;
    }
    
    /**
     * Sets the comment.
     *
     * @param comment the new comment
     */
    public void setComment(Comment comment)
    {
        this.comment = comment;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AddCommentRequest [comment=");
        builder.append(comment);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
