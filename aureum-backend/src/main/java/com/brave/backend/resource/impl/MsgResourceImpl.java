package com.brave.backend.resource.impl;

import com.brave.backend.resource.MsgResource;
import com.brave.backend.resource.impl.service.MsgDeleteService;
import com.brave.backend.resource.impl.service.MsgPublishService;
import com.brave.backend.resource.impl.service.MsgQueryService;
import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.QueryMsgRequest;
import com.brave.backend.resource.message.QueryMsgResponse;

/**
 * The Class MsgResourceImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class MsgResourceImpl implements MsgResource
{
    
    /** {@inheritDoc} */
    
    @Override
    public PublishMsgResponse publish(PublishMsgRequest publishMsgRequest)
    {
        return MsgPublishService.getInstance().execute(publishMsgRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public DeleteMsgResponse delete(DeleteMsgRequest deleteMsgRequest)
    {
        return MsgDeleteService.getInstance().execute(deleteMsgRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public QueryMsgResponse query(QueryMsgRequest queryMsgRequest)
    {
        return MsgQueryService.getInstance().execute(queryMsgRequest);
    }
    
}
