package com.brave.backend.dao.model;

public class Account
{
    private String accountId;
    
    private String accountName;
    
    private String uid;
    
    public String getAccountId()
    {
        return accountId;
    }
    
    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }
    
    public String getAccountName()
    {
        return accountName;
    }
    
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
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
