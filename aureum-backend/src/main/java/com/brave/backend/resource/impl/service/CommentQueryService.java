package com.brave.backend.resource.impl.service;

import java.util.List;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.CommentDao;
import com.brave.backend.dao.model.CommentQueryCondition;
import com.brave.backend.dao.model.CommentWithContent;
import com.brave.backend.resource.message.QueryCommentRequest;
import com.brave.backend.resource.message.QueryCommentResponse;
import com.brave.backend.util.PagingQueryUtil;

/**
 * The Class CommentQueryService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentQueryService
{
    private CommentDao commentDao;
    
    private static CommentQueryService instance;
    
    /**
     * Gets the single instance of CommentQueryService.
     *
     * @return single instance of CommentQueryService
     */
    public static CommentQueryService getInstance()
    {
        if (instance == null)
        {
            synchronized (CommentQueryService.class)
            {
                if (instance == null)
                {
                    instance = ApplicationContextHolder.getInstance()
                        .getApplicationContext()
                        .getBean(CommentQueryService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(CommentQueryService instance)
    {
        CommentQueryService.instance = instance;
    }
    
    /**
     * Sets the comment dao.
     *
     * @param commentDao the new comment dao
     */
    public void setCommentDao(CommentDao commentDao)
    {
        this.commentDao = commentDao;
    }
    
    /**
     * Execute.
     *
     * @param queryCommentRequest the query comment request
     * @return the query comment response
     */
    public QueryCommentResponse execute(QueryCommentRequest queryCommentRequest)
    {
        CommentQueryCondition condition = new CommentQueryCondition();
        condition.setDesc(queryCommentRequest.isDesc());
        condition.setUid(queryCommentRequest.getUid());
        int[] startAndEnd =
            PagingQueryUtil.calculateIndex(queryCommentRequest.getNumPerPage(), queryCommentRequest.getPage());
        condition.setStart(startAndEnd[0]);
        condition.setEnd(startAndEnd[1]);
        condition.setMsgId(queryCommentRequest.getMsgId());
        List<CommentWithContent> comments = commentDao.pagingQuery(condition);
        int count = commentDao.queryCount(condition);
        QueryCommentResponse response = new QueryCommentResponse();
        response.setComments(comments);
        response.setCount(count);
        response.setTotalPages(PagingQueryUtil.calculatePages(queryCommentRequest.getNumPerPage(), count));
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
