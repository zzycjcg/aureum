package com.brave.backend.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.QueryMsgRequest;
import com.brave.backend.resource.message.QueryMsgResponse;

/**
 * The Interface MsgResource.
 */
@Path("msg")
public interface MsgResource
{
    
    /**
     * Publish.
     *
     * @param publishMsgRequest the publish msg request
     * @return the publish msg response
     */
    @POST
    @Path("publish")
    @Produces(MediaType.APPLICATION_JSON)
    PublishMsgResponse publish(PublishMsgRequest publishMsgRequest);
    
    /**
     * Delete.
     *
     * @param deleteMsgRequest the delete msg request
     * @return the delete msg response
     */
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    DeleteMsgResponse delete(DeleteMsgRequest deleteMsgRequest);
    
    /**
     * Query.
     *
     * @param queryMsgRequest the query msg request
     * @return the query msg response
     */
    @POST
    @Path("query")
    @Produces(MediaType.APPLICATION_JSON)
    QueryMsgResponse query(QueryMsgRequest queryMsgRequest);
}
