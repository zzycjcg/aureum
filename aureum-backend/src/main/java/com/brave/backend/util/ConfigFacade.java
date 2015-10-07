package com.brave.backend.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brave.backend.dao.model.Config;
import com.brave.foundation.dao.BaseDao;

/**
 * The Class ConfigFacade.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public final class ConfigFacade
{
    private static final Logger log = LoggerFactory.getLogger(ConfigFacade.class);
    
    private static ConfigFacade instance;
    
    private BaseDao<Config> configDao;
    
    private Map<String, String> configMap = new HashMap<String, String>(0);
    
    /**
     * 调用该方法可以从数据库拉取全量配置到内存.
     */
    public void reload()
    {
        init();
    }
    
    /**
     * Inits the.
     */
    public void init()
    {
        List<Config> allConfigs = configDao.queryAll();
        if (CollectionUtils.isNotEmpty(allConfigs))
        {
            Map<String, String> temp = new HashMap<String, String>(32);
            for (Config config : allConfigs)
            {
                temp.put(config.getConfigName(), config.getConfigValue());
            }
            configMap = temp;
        }
    }
    
    /**
     * Sets the config dao.
     *
     * @param configDao the new config dao
     */
    public void setConfigDao(BaseDao<Config> configDao)
    {
        this.configDao = configDao;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    public static void setInstance(ConfigFacade instance)
    {
        ConfigFacade.instance = instance;
    }
    
    /**
     * Gets the single instance of ConfigFacade.
     *
     * @return single instance of ConfigFacade
     */
    public static ConfigFacade getInstance()
    {
        return instance;
    }
    
    /**
     * Gets the config.
     *
     * @param configName the config name
     * @param defaultValue the default value
     * @return the config
     */
    public String getConfig(String configName, String defaultValue)
    {
        String value = configMap.get(configName);
        if (value == null)
        {
            log.info("no this config name found <{}>, use defaule value <{}>", configName, defaultValue);
            return defaultValue;
        }
        return value;
    }
    
    /**
     * Gets the config.
     *
     * @param configName the config name
     * @return the config
     */
    public String getConfig(String configName)
    {
        return getConfig(configName, null);
    }
    
    /**
     * Gets the config as boolean.
     *
     * @param configName the config name
     * @param defaultValue the default value
     * @return the config as boolean
     */
    public boolean getConfigAsBoolean(String configName, boolean defaultValue)
    {
        String configValue = getConfig(configName);
        if (configValue == null)
        {
            return defaultValue;
        }
        return Boolean.parseBoolean(configValue);
    }
    
    /**
     * Gets the config as boolean.
     *
     * @param configName the config name
     * @return the config as boolean
     */
    public boolean getConfigAsBoolean(String configName)
    {
        return getConfigAsBoolean(configName, false);
    }
    
    /**
     * Gets the config as integer.
     *
     * @param configName the config name
     * @param defaultValue the default value
     * @return the config as integer
     */
    public int getConfigAsInteger(String configName, int defaultValue)
    {
        String configValue = getConfig(configName);
        if (configValue == null)
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt(configValue);
        }
        catch (NumberFormatException e)
        {
            log.error(
                "parse config value to int failed. the config name <{}>. the config value: <{}>. use default value <{}>",
                configName,
                configValue,
                defaultValue,
                e);
            return defaultValue;
        }
    }
    
    /**
     * Gets the config as integer.
     *
     * @param configName the config name
     * @return the config as integer
     */
    public int getConfigAsInteger(String configName)
    {
        return getConfigAsInteger(configName, 0);
    }
}
