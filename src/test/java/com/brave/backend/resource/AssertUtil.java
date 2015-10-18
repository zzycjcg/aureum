package com.brave.backend.resource;

import org.junit.Assert;

import com.brave.backend.constant.ReturnCodes;
import com.brave.backend.constant.ReturnMessages;
import com.brave.backend.resource.message.IResponse;

/**
 * The Class AssertUtil.
 *
 * @author zhiyong zhu at 2015-10-18
 * @since v0.0.1
 */
public abstract class AssertUtil
{
    
    /**
     * Assert response valid.
     *
     * @param response the response
     */
    public static void assertResponseValid(IResponse response)
    {
        Assert.assertTrue(response != null);
        Assert.assertEquals(ReturnCodes.E0000, response.getResultCode());
        Assert.assertEquals(ReturnMessages.E0000, response.getResultMessage());
    }
}
