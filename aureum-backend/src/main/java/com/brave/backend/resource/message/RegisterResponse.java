package com.brave.backend.resource.message;

/**
 * The Class RegisterResponse.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class RegisterResponse extends CommonResponse
{
    private String uid;
    
    /**
     * Gets the uid.
     *
     * @return the uid
     */
    public String getUid()
    {
        return uid;
    }
    
    /**
     * Sets the uid.
     *
     * @param uid the new uid
     */
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("RegisterResponse [uid=");
        builder.append(uid);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
