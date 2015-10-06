package com.brave.backend.resource.message;

public class LoginRequest extends CommonRequest
{
    private String username;
    
    private String password;
    
    private String captcha;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getCaptcha()
    {
        return captcha;
    }
    
    public void setCaptcha(String captcha)
    {
        this.captcha = captcha;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginRequest [username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", captcha=");
        builder.append(captcha);
        builder.append("]");
        return builder.toString();
    }
    
}
