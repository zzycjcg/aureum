package com.brave.backend.dao.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class Config.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
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
    
    /** {@inheritDoc} */
    
    @Override
    public boolean equals(Object other)
    {
        // null will return false
        if (!(other instanceof Config))
        {
            return false;
        }
        
        if (other == this)
        {
            return true;
        }
        
        return StringUtils.equals(this.configName, ((Config)other).getConfigName())
            && StringUtils.equals(this.configValue, ((Config)other).getConfigValue());
    }
    
    /** {@inheritDoc} */
    
    @Override
    public String toString()
    {
        return "Config [configName=" + configName + ", configValue=" + configValue + "]";
    }
}
