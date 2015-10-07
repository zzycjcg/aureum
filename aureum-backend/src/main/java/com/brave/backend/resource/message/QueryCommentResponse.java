package com.brave.backend.resource.message;

import java.util.List;

import com.brave.backend.dao.model.Comment;

/**
 * The Class QueryCommentResponse.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class QueryCommentResponse extends CommonResponse
{
    private List<Comment> comments;
    
    private int totalPages;
    
    private int count;
    
    /**
     * Gets the comments.
     *
     * @return the comments
     */
    public List<Comment> getComments()
    {
        return comments;
    }
    
    /**
     * Sets the comments.
     *
     * @param comments the new comments
     */
    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }
    
    /**
     * Gets the total pages.
     *
     * @return the total pages
     */
    public int getTotalPages()
    {
        return totalPages;
    }
    
    /**
     * Sets the total pages.
     *
     * @param totalPages the new total pages
     */
    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }
    
    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount()
    {
        return count;
    }
    
    /**
     * Sets the count.
     *
     * @param count the new count
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryCommentResponse [comments=");
        builder.append(comments);
        builder.append(", totalPages=");
        builder.append(totalPages);
        builder.append(", count=");
        builder.append(count);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
