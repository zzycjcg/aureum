package com.brave.backend.dao.model;

public class Account
{
    private String profileID;
    
    private double money;
    
    /**
     * @return the profileID
     */
    public String getProfileID()
    {
        return profileID;
    }
    
    /**
     * @param profileID the profileID to set
     */
    public void setProfileID(String profileID)
    {
        this.profileID = profileID;
    }
    
    /**
     * @return the money
     */
    public double getMoney()
    {
        return money;
    }
    
    /**
     * @param money the money to set
     */
    public void setMoney(double money)
    {
        this.money = money;
    }
    
}
