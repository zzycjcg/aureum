package com.brave.backend.dao.model;

/**
 * The Class Account.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public class Account
{
    private String accountId;
    
    private String accountName;
    
    private String uid;
    
    /**
     * Gets the account id.
     *
     * @return the account id
     */
    public String getAccountId()
    {
        return accountId;
    }
    
    /**
     * Sets the account id.
     *
     * @param accountId the new account id
     */
    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
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
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Account [accountId=");
        builder.append(accountId);
        builder.append(", accountName=");
        builder.append(accountName);
        builder.append(", uid=");
        builder.append(uid);
        builder.append("]");
        return builder.toString();
    }
}
