package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.CommentDao;
import com.brave.backend.dao.model.Comment;
import com.brave.backend.resource.message.AddCommentRequest;
import com.brave.backend.resource.message.AddCommentResponse;
import com.brave.backend.util.JodaTimeUtil;
import com.brave.backend.util.JodaTimeUtil.DateFormats;
import com.brave.backend.util.JsonUtil;
import com.brave.backend.util.SessionAttributesUtil;
import com.brave.backend.util.UUIDUtil;

/**
 * The Class CommentAddService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class CommentAddService
{
    private CommentDao commentDao;
    
    private static CommentAddService instance;
    
    /**
     * Gets the single instance of CommentAddService.
     *
     * @return single instance of CommentAddService
     */
    public static CommentAddService getInstance()
    {
        if (instance == null)
        {
            synchronized (CommentAddService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(CommentAddService.class);
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
    public static void setInstance(CommentAddService instance)
    {
        CommentAddService.instance = instance;
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
     * @param addCommentRequest the add comment request
     * @return the adds the comment response
     */
    public AddCommentResponse execute(AddCommentRequest addCommentRequest)
    {
        AddCommentResponse response = new AddCommentResponse();
        String uid = SessionAttributesUtil.getUid();
        // not login
        if (uid == null)
        {
            response.setResultCode(ReturnCodes.E1004);
            response.setResultMessage(ReturnMessages.E1002);
            return response;
        }
        String commentId = UUIDUtil.generateCommentId();
        
        // comment data
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setCreateTime(JodaTimeUtil.getCurrentUTCTime(DateFormats.FORMAT_1));
        comment.setMsgId(addCommentRequest.getComment().getMsgId());
        comment.setUid(uid);
        comment.setText(addCommentRequest.getComment().getContent().getText());
        comment.setMultiMedia(JsonUtil.toJson(addCommentRequest.getComment().getContent().getImageUrls()));
        
        commentDao.insert(comment);
        
        response.setCommentId(commentId);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
