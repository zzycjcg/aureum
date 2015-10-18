package com.brave.backend.resource.message;

/**
 * The Class AddCommentResponse.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class AddCommentResponse extends CommonResponse
{
    private String commentId;
    
    /**
     * Gets the comment id.
     *
     * @return the comment id
     */
    public String getCommentId()
    {
        return commentId;
    }
    
    /**
     * Sets the comment id.
     *
     * @param commentId the new comment id
     */
    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AddCommentResponse [commentId=");
        builder.append(commentId);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
