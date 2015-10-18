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

import com.brave.backend.resource.message.AddCommentRequest;
import com.brave.backend.resource.message.AddCommentResponse;
import com.brave.backend.resource.message.DeleteCommentRequest;
import com.brave.backend.resource.message.DeleteCommentResponse;
import com.brave.backend.resource.message.PublishMsgRequest;
import com.brave.backend.resource.message.PublishMsgResponse;
import com.brave.backend.resource.message.QueryCommentRequest;
import com.brave.backend.resource.message.QueryCommentResponse;
import com.brave.backend.resource.message.data.Comment;
import com.brave.backend.resource.message.data.Content;

/**
 * The Class CommentResourceTest.
 *
 * @author zhiyong zhu at 2015-10-18
 * @since v0.0.1
 */
public class CommentResourceTest extends UserBasedAbstractTest
{
    @Autowired
    private CommentResource commentResource;
    
    @Autowired
    private MsgResource msgResource;
    
    private String msgId;
    
    private final Map<Integer, String> commentIdMap = new HashMap<Integer, String>();
    
    /**
     * Prepare.
     */
    @Before
    public void prepare()
    {
        doRegister();
        doLogin();
        doPublishMsg(1);
    }
    
    /**
     * Test delete comment.
     */
    @Test
    public void testDeleteComment()
    {
        doAddComment(1);
        doDeleteComment();
    }
    
    /**
     * Test query comment.
     */
    @Test
    public void testQueryComment()
    {
        int count = 5;
        doAddComment(count);
        doQueryComment(count);
        doDeleteComment();
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
        AssertUtil.assertResponseValid(response);
        String msgId = null;
        Assert.assertTrue(StringUtils.isNotEmpty(msgId = response.getMsgId()));
        this.msgId = msgId;
    }
    
    private void doAddComment(int size)
    {
        Comment comment = null;
        List<String> imageUrls = null;
        Content content = null;
        AddCommentRequest request = null;
        AddCommentResponse response = null;
        for (int i = 1; i <= size; i++)
        {
            content = new Content();
            content.setText("[comment" + String.valueOf(i) + "]Hi! This my first msg. Welcome to brave msg-sys.");
            imageUrls = new ArrayList<String>();
            imageUrls.add("comment" + String.valueOf(i) + "]http://www.baidu.com/img/bdlogo.png");
            imageUrls.add("[comment" + String.valueOf(i)
                + "]https://upload.wikimedia.org/wikipedia/en/d/de/Alibaba_Group_Logo.png");
            content.setImageUrls(imageUrls);
            comment = new Comment();
            comment.setMsgId(this.msgId);
            comment.setContent(content);
            request = new AddCommentRequest();
            request.setComment(comment);
            response = commentResource.add(request);
            AssertUtil.assertResponseValid(response);
            Assert.assertTrue(StringUtils.isNotEmpty(response.getCommentId()));
            commentIdMap.put(i, response.getCommentId());
            if (size > 1)
            {
                try
                {
                    // 每隔2s发布一条评论
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void doQueryComment(int count)
    {
        QueryCommentRequest request = new QueryCommentRequest();
        request.setMsgId(this.msgId);
        request.setDesc(true);
        request.setNumPerPage(10);
        request.setPage(1);
        request.setUid(super.uid);
        QueryCommentResponse response = commentResource.query(request);
        AssertUtil.assertResponseValid(response);
        Assert.assertTrue(response.getCount() == count);
        Assert.assertTrue(response.getTotalPages() == 1);
        for (int i = 1; i <= count; i++)
        {
            Assert.assertEquals(commentIdMap.get(count - i + 1), response.getComments().get(i - 1).getCommentId());
        }
    }
    
    private void doDeleteComment()
    {
        DeleteCommentRequest request = new DeleteCommentRequest();
        request.setCommentIds(new ArrayList<>(commentIdMap.values()));
        DeleteCommentResponse response = commentResource.delete(request);
        AssertUtil.assertResponseValid(response);
        commentIdMap.clear();
    }
}
