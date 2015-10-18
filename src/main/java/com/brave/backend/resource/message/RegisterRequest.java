package com.brave.backend.resource.message;

/**
 * The Class RegisterRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class RegisterRequest extends CommonRequest
{
    private String username;
    
    private String password;
    
    private String email;
    
    private String mobilePhone;
    
    private String brief;
    
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
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
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
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
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
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Gets the mobile phone.
     *
     * @return the mobilePhone
     */
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    
    /**
     * Sets the mobile phone.
     *
     * @param mobilePhone the mobilePhone to set
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
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
