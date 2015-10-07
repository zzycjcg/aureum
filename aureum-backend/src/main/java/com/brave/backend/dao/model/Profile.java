package com.brave.backend.dao.model;

/**
 * The Class Profile.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class Profile
{
    private String profileId;
    
    private String username;
    
    private String email;
    
    private String mobilePhone;
    
    private String brief;
    
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
    
    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Gets the mobile phone.
     *
     * @return the mobile phone
     */
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    /**
     * Sets the mobile phone.
     *
     * @param mobilePhone the new mobile phone
     */
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    /**
     * Gets the brief.
     *
     * @return the brief
     */
    public String getBrief()
    {
        return brief;
    }
    
    /**
     * Sets the brief.
     *
     * @param brief the new brief
     */
    public void setBrief(String brief)
    {
        this.brief = brief;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Profile [profileId=");
        builder.append(profileId);
        builder.append(", username=");
        builder.append(username);
        builder.append(", email=");
        builder.append(email);
        builder.append(", mobilePhone=");
        builder.append(mobilePhone);
        builder.append(", brief=");
        builder.append(brief);
        builder.append("]");
        return builder.toString();
    }
    
}
