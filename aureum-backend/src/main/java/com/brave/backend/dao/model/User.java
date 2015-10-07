package com.brave.backend.dao.model;

/**
 * The Class User.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class User
{
    private String uid;
    
    private String createTime;
    
    private char status;
    
    private String password;
    
    private String profileId;
    
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
    
    /**
     * Gets the creates the time.
     *
     * @return the creates the time
     */
    public String getCreateTime()
    {
        return createTime;
    }
    
    /**
     * Sets the creates the time.
     *
     * @param createTime the new creates the time
     */
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    /**
     * Gets the status.
     *
     * @return the status
     */
    public char getStatus()
    {
        return status;
    }
    
    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(char status)
    {
        this.status = status;
    }
    
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * Gets the profile id.
     *
     * @return the profile id
     */
    public String getProfileId()
    {
        return profileId;
    }
    
    /**
     * Sets the profile id.
     *
     * @param profileId the new profile id
     */
    public void setProfileId(String profileId)
    {
        this.profileId = profileId;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("User [uid=");
        builder.append(uid);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", status=");
        builder.append(status);
        builder.append(", password=");
        builder.append(password);
        builder.append(", profileId=");
        builder.append(profileId);
        builder.append("]");
        return builder.toString();
    }
    
}
