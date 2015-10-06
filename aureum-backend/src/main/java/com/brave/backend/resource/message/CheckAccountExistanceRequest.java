package com.brave.backend.resource.message;

public class CheckAccountExistanceRequest extends CommonRequest
{
    private String accountName;
    
    public String getAccountName()
    {
        return accountName;
    }
    
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
        builder.append("]");
        return builder.toString();
    }
    
}
