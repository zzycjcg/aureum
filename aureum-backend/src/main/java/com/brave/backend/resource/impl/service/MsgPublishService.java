package com.brave.backend.resource.impl.service;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.container.ApplicationContextHolder;
import com.brave.backend.dao.MsgDao;
import com.brave.backend.dao.model.Msg;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.util.JodaTimeUtil;
import com.brave.backend.util.JodaTimeUtil.DateFormats;
import com.brave.backend.util.JsonUtil;
import com.brave.backend.util.SessionAttributesUtil;
import com.brave.backend.util.UUIDUtil;

/**
 * The Class MsgPublishService.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class MsgPublishService
{
    
    /** The msg dao. */
    private MsgDao msgDao;
    
    private static MsgPublishService instance;
    
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
    public static void setInstance(MsgPublishService instance)
    {
        MsgPublishService.instance = instance;
    }
    
    /**
     * Gets the single instance of MsgPublishService.
     *
     * @return single instance of MsgPublishService
     */
    public static MsgPublishService getInstance()
    {
        if (instance == null)
        {
            synchronized (MsgPublishService.class)
            {
                if (instance == null)
                {
                    instance =
                        ApplicationContextHolder.getInstance().getApplicationContext().getBean(MsgPublishService.class);
                }
            }
        }
        return instance;
    }
    
    /**
     * Execute.
     *
     * @param publishMsgRequest the publish msg request
     * @return the publish msg response
     */
    public PublishMsgResponse execute(PublishMsgRequest publishMsgRequest)
    {
        PublishMsgResponse response = new PublishMsgResponse();
        String uid = SessionAttributesUtil.getUid();
        // not login
        if (uid == null)
        {
            response.setResultCode(ReturnCodes.E1004);
            response.setResultMessage(ReturnMessages.E1002);
            return response;
        }
        String msgId = UUIDUtil.generateMsgId();
        Msg msg = new Msg();
        msg.setMsgId(msgId);
        msg.setCreateTime(JodaTimeUtil.getCurrentUTCTime(DateFormats.FORMAT_1));
        msg.setUid(uid);
        msg.setText(publishMsgRequest.getContent().getText());
        msg.setMultiMedia(JsonUtil.toJson(publishMsgRequest.getContent().getImageUrls()));
        
        msgDao.insert(msg);
        
        response.setMsgId(msgId);
        response.setResultCode(ReturnCodes.E0000);
        response.setResultMessage(ReturnMessages.E0000);
        return response;
    }
}
