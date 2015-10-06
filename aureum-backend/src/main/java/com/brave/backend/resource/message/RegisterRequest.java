package com.brave.backend.resource.message;

public class RegisterRequest
{
    private String username;
    
    private String password;
    
    private String email;
    
    private String mobilePhone;
    
    private String brief;
    
    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * @return the mobilePhone
     */
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }
    
    /**
     * @return the brief
     */
    public String getBrief()
    {
        return brief;
    }
    
    /**
     * @param brief the brief to set
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
        builder.append("RegisterRequest [username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
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
