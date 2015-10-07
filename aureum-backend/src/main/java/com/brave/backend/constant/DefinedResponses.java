package com.brave.backend.constant;

import com.brave.backend.resource.message.IResponse;

/**
 * The Interface UsefulResponses.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface DefinedResponses
{
    
    /** 数据库异常. */
    IResponse DB_ERROR = new IResponse()
    {
        
        /** {@inheritDoc} */
        
        @Override
        public String getResultMessage()
        {
            return ReturnMessages.E9001;
        }
        
        /** {@inheritDoc} */
        
        @Override
        public String getResultCode()
        {
            return ReturnCodes.E9001;
        }
    };
    
    /** 未知异常. */
    IResponse UNKNOWN_ERROR = new IResponse()
    {
        
        /** {@inheritDoc} */
        
        @Override
        public String getResultMessage()
        {
            return ReturnMessages.E9999;
        }
        
        /** {@inheritDoc} */
        
        @Override
        public String getResultCode()
        {
            return ReturnCodes.E9999;
        }
    };
}
