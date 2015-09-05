package com.brave.backend.dao.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class Config.
 */
public class Config
{
    /** The config name. */
    private String configName;
    
    /** The config value. */
    private String configValue;
    
    /**
     * Gets the config name.
     *
     * @return the config name
     */
    public String getConfigName()
    {
        return configName;
    }
    
    /**
     * Sets the config name.
     *
     * @param configName the new config name
     */
    public void setConfigName(String configName)
    {
        this.configName = configName;
    }
    
    /**
     * Gets the config value.
     *
     * @return the config value
     */
    public String getConfigValue()
    {
        return configValue;
    }
    
    /**
     * Sets the config value.
     *
     * @param configValue the new config value
     */
    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }
    
    @Override
    public int hashCode()
    {
        // TODO
        if (this.configName != null && this.configValue != null)
        {
            return this.configName.hashCode() ^ this.configValue.hashCode();
        }
        return configName.hashCode();
    }
    
    /** {@inheritDoc} */
    
    @Override
    public boolean equals(Object other)
    {
        
        // null will return false
        if (!(other instanceof Config))
        {
            return false;
        }
        
        if (other.hashCode() == this.hashCode())
        {
            return true;
        }
        
        Config otherConfig = (Config)other;
        return StringUtils.equals(this.configName, otherConfig.getConfigName())
            && StringUtils.equals(this.configValue, otherConfig.getConfigValue());
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        return "Config [configName=" + configName + ", configValue=" + configValue + "]";
    }
}
