package com.brave.backend.resource.message;

public class LoginResponse extends CommonResponse
{
    private String uid;
    
    public String getUid()
    {
        return uid;
    }
    
    public void setUid(String uid)
    {
        this.uid = uid;
    }
    
    @Override
    public String toString()
    {
        return "LoginResponse [uid=" + uid + "]";
    }
    
}
