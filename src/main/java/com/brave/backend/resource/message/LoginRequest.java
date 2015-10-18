package com.brave.backend.resource.message;

/**
 * The Class LoginRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class LoginRequest extends CommonRequest
{
    private String username;
    
    private String password;
    
    private String captcha;
    
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
     * Gets the captcha.
     *
     * @return the captcha
     */
    public String getCaptcha()
    {
        return captcha;
    }
    
    /**
     * Sets the captcha.
     *
     * @param captcha the new captcha
     */
    public void setCaptcha(String captcha)
    {
        this.captcha = captcha;
    }
    
    /** {@inheritDoc} */
    
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
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
