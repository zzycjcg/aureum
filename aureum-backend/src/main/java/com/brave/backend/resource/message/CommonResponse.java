package com.brave.backend.resource.message;

/**
 * The Class CommonResponse.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public abstract class CommonResponse implements IResponse
{
    
    /** The result code. */
    protected String resultCode;
    
    /** The result message. */
    protected String resultMessage;
    
    /**
     * Gets the result code.
     *
     * @return the result code
     */
    @Override
    public String getResultCode()
    {
        return resultCode;
    }
    
    /**
     * Sets the result code.
     *
     * @param resultCode the new result code
     */
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    /**
     * Gets the result message.
     *
     * @return the result message
     */
    @Override
    public String getResultMessage()
    {
        return resultMessage;
    }
    
    /**
     * Sets the result message.
     *
     * @param resultMessage the new result message
     */
    public void setResultMessage(String resultMessage)
    {
        this.resultMessage = resultMessage;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CommonResponse [resultCode=");
        builder.append(resultCode);
        builder.append(", resultMessage=");
        builder.append(resultMessage);
        builder.append("]");
        return builder.toString();
    }
    
}
