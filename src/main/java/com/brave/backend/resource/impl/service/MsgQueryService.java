package com.brave.backend.resource.impl.service;

import java.util.List;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.MsgDao;
import com.brave.backend.dao.model.Msg;
import com.brave.backend.dao.model.MsgQueryCondition;
import com.brave.backend.resource.message.QueryMsgRequest;
import com.brave.backend.resource.message.QueryMsgResponse;
import com.brave.backend.util.PagingQueryUtil;

/**
 * The Class MsgQueryService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class MsgQueryService
{
    
    /** The msg dao. */
    private MsgDao msgDao;
    
    /** The instance. */
    private static MsgQueryService instance;
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(MsgQueryService instance)
    {
        MsgQueryService.instance = instance;
    }
    
    /**
     * Gets the single instance of MsgQueryService.
     *
     * @return single instance of MsgQueryService
     */
    public static MsgQueryService getInstance()
    {
        if (instance == null)
        {
            synchronized (MsgQueryService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(MsgQueryService.class);
                }
            }
        }
        
        return instance;
    }
    
    /**
     * Sets the msg dao.
     *
     * @param msgDao the new msg dao
     */
    public void setMsgDao(MsgDao msgDao)
    {
        this.msgDao = msgDao;
    }
    
    /**
     * Execute.
     *
     * @param queryMsgRequest the query msg request
     * @return the query msg response
     */
    public QueryMsgResponse execute(QueryMsgRequest queryMsgRequest)
    {
        QueryMsgResponse response = new QueryMsgResponse();
        MsgQueryCondition condition = new MsgQueryCondition();
        condition.setDesc(queryMsgRequest.isDesc());
        condition.setUid(queryMsgRequest.getUid());
        int start = PagingQueryUtil.calculateStart(queryMsgRequest.getNumPerPage(), queryMsgRequest.getPage());
        condition.setStart(start);
        condition.setNumPerPage(queryMsgRequest.getNumPerPage());
        List<Msg> msgs = msgDao.pagingQuery(condition);
        int count = msgDao.queryCount(condition);
        response.setMsgs(msgs);
        response.setCount(count);
        response.setTotalPages(PagingQueryUtil.calculatePages(queryMsgRequest.getNumPerPage(), count));
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
    
}
