package com.brave.backend.resource.message;

/**
 * The Class CheckAccountExistanceRequest.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class CheckAccountExistanceRequest extends CommonRequest
{
    private String accountName;
    
    /**
     * Gets the account name.
     *
     * @return the account name
     */
    public String getAccountName()
    {
        return accountName;
    }
    
    /**
     * Sets the account name.
     *
     * @param accountName the new account name
     */
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("CheckAccountExistanceRequest [accountName=");
        builder.append(accountName);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
