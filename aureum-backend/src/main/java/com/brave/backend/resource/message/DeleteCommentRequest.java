package com.brave.backend.resource.message;

import java.util.List;

public class DeleteCommentRequest extends CommonRequest
{
    private List<String> commentIds;
    
    public List<String> getCommentIds()
    {
        return commentIds;
    }
    
    public void setCommentIds(List<String> commentIds)
    {
        this.commentIds = commentIds;
    }
    
    @Override
    public String toString()
    {
        return "DeleteCommonRequest [commentIds=" + commentIds + "]";
    }
    
}
