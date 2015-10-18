package com.brave.backend.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brave.backend.resource.message.AddCommentRequest;
import com.brave.backend.resource.message.AddCommentResponse;
import com.brave.backend.resource.message.DeleteCommentResponse;
import com.brave.backend.resource.message.DeleteCommentRequest;
import com.brave.backend.resource.message.QueryCommentRequest;
import com.brave.backend.resource.message.QueryCommentResponse;

/**
 * The Interface CommentResource.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
@Path("comment")
public interface CommentResource
{
    
    /**
     * 新增评论.
     *
     * @param addCommentRequest the add comment request
     * @return the adds the comment response
     */
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    AddCommentResponse add(AddCommentRequest addCommentRequest);
    
    /**
     * 删除评论.
     *
     * @param deleteCommentRequest the delete comment request
     * @return the delete comment response
     */
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    DeleteCommentResponse delete(DeleteCommentRequest deleteCommentRequest);
    
    /**
     * 查询评论.
     *
     * @param queryCommentRequest the query comment request
     * @return the query comment response
     */
    @POST
    @Path("query")
    @Produces(MediaType.APPLICATION_JSON)
    QueryCommentResponse query(QueryCommentRequest queryCommentRequest);
}
