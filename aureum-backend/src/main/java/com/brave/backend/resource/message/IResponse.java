package com.brave.backend.resource.message;

/**
 * The Interface IResponse.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public interface IResponse
{
    /**
     * Gets the result code.
     *
     * @return the result code
     */
    String getResultCode();
    
    /**
     * Gets the result message.
     *
     * @return the result message
     */
    String getResultMessage();
}
