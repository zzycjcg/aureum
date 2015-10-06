package com.brave.backend.dao.model;

public class User
{
    private String uid;
    
    private String createTime;
    
    private char status;
    
    private String password;
    
    private String profileId;
    
    public String getUid()
    {
        return uid;
    }
    
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public char getStatus()
    {
        return status;
    }
    
    public void setStatus(char status)
    {
        this.status = status;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getProfileId()
    {
        return profileId;
    }
    
    public void setProfileId(String profileId)
    {
        this.profileId = profileId;
    }
    
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
