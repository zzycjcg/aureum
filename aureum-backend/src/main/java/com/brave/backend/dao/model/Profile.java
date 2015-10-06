package com.brave.backend.dao.model;

public class Profile
{
    private String profileId;
    
    private String username;
    
    private String email;
    
    private String mobilePhone;
    
    private String brief;
    
    public String getProfileId()
    {
        return profileId;
    }
    
    public void setProfileId(String profileId)
    {
        this.profileId = profileId;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    public String getBrief()
    {
        return brief;
    }
    
    public void setBrief(String brief)
    {
        this.brief = brief;
    }
    
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
