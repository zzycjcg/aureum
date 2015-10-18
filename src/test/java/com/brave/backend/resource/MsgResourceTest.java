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
        int count = 5;
        doPublishMsg(count);
        doQueryMsg(count);
        doDeleteMsg();
    }
    
    private void doPublishMsg(int count)
    {
        Content content = null;
        List<String> imageUrls = null;
        PublishMsgRequest request = null;
        PublishMsgResponse response = null;
        for (int i = 1; i <= count; i++)
        {
            content = new Content();
            content.setText("[msg" + String.valueOf(i) + "]Hi! This my first msg. Welcome to brave msg-sys.");
            imageUrls = new ArrayList<String>();
            imageUrls.add("[msg" + String.valueOf(i) + "]http://www.baidu.com/img/bdlogo.png");
            imageUrls.add(
                "[msg" + String.valueOf(i) + "]https://upload.wikimedia.org/wikipedia/en/d/de/Alibaba_Group_Logo.png");
            content.setImageUrls(imageUrls);
            request = new PublishMsgRequest();
            request.setContent(content);
            response = msgResource.publish(request);
            AssertUtil.assertResponseValid(response);
            Assert.assertTrue(StringUtils.isNotEmpty(response.getMsgId()));
            msgIdMap.put(i, response.getMsgId());
            if (count > 1)
            {
                try
                {
                    // 每隔2s发布一条消息
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void doDeleteMsg()
    {
        List<String> msgIds = new ArrayList<String>();
        msgIds.addAll(msgIdMap.values());
        DeleteMsgRequest request = new DeleteMsgRequest();
        request.setMsgIds(msgIds);
        DeleteMsgResponse response = msgResource.delete(request);
        AssertUtil.assertResponseValid(response);
        msgIdMap.clear();
    }
    
    private void doQueryMsg(int count)
    {
        QueryMsgRequest request = new QueryMsgRequest();
        request.setDesc(true);
        request.setNumPerPage(10);
        request.setPage(1);
        request.setUid(super.uid);
        QueryMsgResponse response = msgResource.query(request);
        AssertUtil.assertResponseValid(response);
        Assert.assertTrue(response.getCount() == count);
        Assert.assertTrue(response.getTotalPages() == 1);
        for (int i = 1; i <= count; i++)
        {
            Assert.assertEquals(msgIdMap.get(count - i + 1), response.getMsgs().get(i - 1).getMsgId());
        }
    }
    
}
