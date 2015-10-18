package com.brave.backend.resource.impl.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.MsgDao;
import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.util.SessionAttributesUtil;

/**
 * The Class MsgDeleteService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class MsgDeleteService
{
    /** The msg dao. */
    private MsgDao msgDao;
    
    private static MsgDeleteService instance;
    
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
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(MsgDeleteService instance)
    {
        MsgDeleteService.instance = instance;
    }
    
    /**
     * Gets the single instance of MsgDeleteService.
     *
     * @return single instance of MsgDeleteService
     */
    public static MsgDeleteService getInstance()
    {
        if (instance == null)
        {
            synchronized (MsgDeleteService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(MsgDeleteService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Execute.
     *
     * @param deleteMsgRequest the delete msg request
     * @return the delete msg response
     */
    public DeleteMsgResponse execute(DeleteMsgRequest deleteMsgRequest)
    {
        DeleteMsgResponse response = new DeleteMsgResponse();
        String uid = SessionAttributesUtil.getUid();
        // not login
        if (uid == null)
        {
            response.setResultCode(ReturnCodes.E1004);
            response.setResultMessage(ReturnMessages.E1002);
            return response;
        }
        operateDB(deleteMsgRequest.getMsgIds(), uid);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
    
    /**
     * Operate db.
     *
     * @param msgIds the msg ids
     */
    // TODO 验证事务
    private void operateDB(List<String> msgIds, String uid)
    {
        if (CollectionUtils.isEmpty(msgIds))
        {
            return;
        }
        for (String msgId : msgIds)
        {
            if (hasDelPermission(msgId, uid))
            {
                msgDao.delete(msgId);
            }
        }
    }
    
    private boolean hasDelPermission(String commentId, String uid)
    {
        // TODO 权限控制：只有消息发布者才能删除
        return true;
    }
}
