package com.brave.backend.resource.message;

/**
 * The Class CheckAccountExistanceResponse.
 */
public class CheckAccountExistanceResponse extends CommonResponse
{
    
    /** The exist. */
    private boolean exist;
    
    /**
     * Checks if is exist.
     *
     * @return true, if is exist
     */
    public boolean isExist()
    {
        return exist;
    }
    
    /**
     * Sets the exist.
     *
     * @param exist the new exist
     */
    public void setExist(boolean exist)
    {
        this.exist = exist;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CheckAccountExistanceResponse [exist=");
        builder.append(exist);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
    
}
