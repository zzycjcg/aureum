package com.brave.backend.resource.message;

import com.brave.backend.resource.message.data.Comment;

public class AddCommentRequest extends CommonRequest
{
    private Comment comment;
    
    public Comment getComment()
    {
        return comment;
    }
    
    public void setComment(Comment comment)
    {
        this.comment = comment;
    }
    
    @Override
    public String toString()
    {
        return "AddCommentRequest [comment=" + comment + "]";
    }
    
}
