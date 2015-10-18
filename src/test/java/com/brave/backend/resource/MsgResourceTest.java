package com.brave.backend.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.resource.message.DeleteMsgRequest;
import com.brave.backend.resource.message.DeleteMsgResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.QueryMsgRequest;
import com.brave.backend.resource.message.QueryMsgResponse;
import com.brave.backend.resource.message.data.Content;

/**
 * The Class MsgResourceTest.
 *
 * @author zhiyong zhu at 2015-10-16
 * @since v0.0.1
 */
public class MsgResourceTest extends UserBasedAbstractTest
{
    @Autowired
    private MsgResource msgResource;
    
    private String uid;
    
    private final Map<Integer, String> msgIdMap = new HashMap<Integer, String>();
    
    /**
     * Prepare.
     */
    @Before
    public void prepare()
    {
        doRegister();
        doLogin();
    }
    
    /**
     * Test publish msg.
     */
    @Test
    public void testPublishMsg()
    {
        doPublishMsg(0);
        doDeleteMsg();
    }
    
    /**
     * Test delete msg.
     */
    @Test
    public void testDeleteMsg()
    {
        doPublishMsg(0);
        doDeleteMsg();
    }
    
    /**
     * Test query msg.
     */
    @Test
    public void testQueryMsg()
    {
        doQueryMsg();
        doDeleteMsg();
    }
    
    private void doPublishMsg(int index)
    {
        Content content = new Content();
        content.setText("[msg" + String.valueOf(index) + "]Hi! This my first msg. Welcome to brave msg-sys.");
        List<String> imageUrls = new ArrayList<String>();
        imageUrls.add("[msg" + String.valueOf(index) + "]http://www.baidu.com/img/bdlogo.png");
        imageUrls.add(
            "[msg" + String.valueOf(index) + "]https://upload.wikimedia.org/wikipedia/en/d/de/Alibaba_Group_Logo.png");
        content.setImageUrls(imageUrls);
        PublishMsgRequest request = new PublishMsgRequest();
        request.setContent(content);
        PublishMsgResponse response = msgResource.publish(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        String msgId = null;
        Assert.assertTrue(StringUtils.isNotEmpty(msgId = response.getMsgId()));
        msgIdMap.put(index, msgId);
    }
    
    private void doDeleteMsg()
    {
        List<String> msgIds = new ArrayList<String>();
        msgIds.addAll(msgIdMap.values());
        DeleteMsgRequest request = new DeleteMsgRequest();
        request.setMsgIds(msgIds);
        DeleteMsgResponse response = msgResource.delete(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        msgIdMap.clear();
    }
    
    private void doQueryMsg()
    {
        int count = 5;
        // 发布5条消息
        for (int i = 0; i < count; i++)
        {
            doPublishMsg(i);
            try
            {
                // 每隔2s发布一条消息
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        QueryMsgRequest request = new QueryMsgRequest();
        request.setDesc(true);
        request.setNumPerPage(10);
        request.setPage(1);
        request.setUid(uid);
        QueryMsgResponse response = msgResource.query(request);
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
        Assert.assertTrue(response.getCount() == count);
        for (int i = 0; i < count; i++)
        {
            Assert.assertEquals(msgIdMap.get(count - 1 - i), response.getMsgs().get(i).getMsgId());
        }
    }
    
}
