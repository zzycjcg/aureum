package com.brave.backend.resource.impl.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.CommentDao;
import com.brave.backend.resource.message.DeleteCommentRequest;
import com.brave.backend.resource.message.DeleteCommentResponse;
import com.brave.backend.util.SessionAttributesUtil;

/**
 * The Class CommentDeleteService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentDeleteService
{
    private CommentDao commentDao;
    
    private static CommentDeleteService instance;
    
    /**
     * Gets the single instance of CommentDeleteService.
     *
     * @return single instance of CommentDeleteService
     */
    public static CommentDeleteService getInstance()
    {
        if (instance == null)
        {
            synchronized (CommentDeleteService.class)
            {
                if (instance == null)
                {
                    instance = ApplicationContextHolder.getInstance()
                        .getApplicationContext()
                        .getBean(CommentDeleteService.class);
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
    public static void setInstance(CommentDeleteService instance)
    {
        CommentDeleteService.instance = instance;
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
     * @param deleteCommentRequest the delete comment request
     * @return the delete comment response
     */
    public DeleteCommentResponse execute(DeleteCommentRequest deleteCommentRequest)
    {
        DeleteCommentResponse response = new DeleteCommentResponse();
        String uid = SessionAttributesUtil.getUid();
        // not login
        if (uid == null)
        {
            response.setResultCode(ReturnCodes.E1004);
            response.setResultMessage(ReturnMessages.E1002);
            return response;
        }
        operateDB(deleteCommentRequest.getCommentIds(), uid);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
    
    // TODO 事务
    private void operateDB(List<String> commentIds, String uid)
    {
        if (CollectionUtils.isEmpty(commentIds))
        {
            return;
        }
        for (String commentId : commentIds)
        {
            if (hasDelPermission(commentId, uid))
            {
                // TODO 关联删除
                commentDao.delete(commentId);
            }
        }
    }
    
    private boolean hasDelPermission(String commentId, String uid)
    {
        // TODO 权限控制：只有消息发布者或者评论作者才能删除指定评论 
        return true;
    }
}
