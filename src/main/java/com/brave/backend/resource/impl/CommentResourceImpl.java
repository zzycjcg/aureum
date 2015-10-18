package com.brave.backend.resource.impl;

import com.brave.backend.resource.CommentResource;
import com.brave.backend.resource.impl.service.CommentAddService;
import com.brave.backend.resource.impl.service.CommentDeleteService;
import com.brave.backend.resource.impl.service.CommentQueryService;
import com.brave.backend.resource.message.AddCommentRequest;
import com.brave.backend.resource.message.AddCommentResponse;
import com.brave.backend.resource.message.DeleteCommentResponse;
import com.brave.backend.resource.message.DeleteCommentRequest;
import com.brave.backend.resource.message.QueryCommentRequest;
import com.brave.backend.resource.message.QueryCommentResponse;

/**
 * The Class CommentResourceImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentResourceImpl implements CommentResource
{
    
    /** {@inheritDoc} */
    
    @Override
    public AddCommentResponse add(AddCommentRequest addCommentRequest)
    {
        return CommentAddService.getInstance().execute(addCommentRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public DeleteCommentResponse delete(DeleteCommentRequest deleteCommentRequest)
    {
        return CommentDeleteService.getInstance().execute(deleteCommentRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public QueryCommentResponse query(QueryCommentRequest queryCommentRequest)
    {
        return CommentQueryService.getInstance().execute(queryCommentRequest);
    }
    
}
