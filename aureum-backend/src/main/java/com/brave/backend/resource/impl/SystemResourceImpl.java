package com.brave.backend.resource.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brave.backend.dao.model.Config;
import com.brave.backend.resource.SystemResource;
import com.brave.backend.util.ConfigFacade;
import com.brave.foundation.dao.BaseDao;

/**
 * The Class SystemResourceImpl.
 */
public class SystemResourceImpl implements SystemResource
{
    private static final Logger log = LoggerFactory.getLogger(SystemResourceImpl.class);
    
    private String httpUrl;
    
    private String httpsUrl;
    
    private volatile boolean portalUrlInitial = false;
    
    private BaseDao<Config> configDao;
    
    public void setConfigDao(BaseDao<Config> configDao)
    {
        this.configDao = configDao;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public Map<String, Object> getConfig(String configName)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        // test configure service
        map.put(configName, ConfigFacade.getInstance().getConfig(configName));
        return map;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void addConfig(List<Config> configs)
    {
        if (CollectionUtils.isEmpty(configs))
        {
            log.warn("config list is null or empty.");
            return;
        }
        for (Config config : configs)
        {
            if ("mysql".equalsIgnoreCase(config.getConfigName()))
            {
                throw new IllegalArgumentException("illegal arg: mysql.");
            }
            Config origin = configDao.querySingle(config.getConfigName());
            if (origin != null)
            {
                configDao.update(config);
                log.debug("update config: configName={}, replace configValue:{} with {}.",
                    config.getConfigName(),
                    origin.getConfigValue(),
                    config.getConfigValue());
            }
            else
            {
                configDao.insert(config);
            }
        }
    }
    
    @Override
    public Map<String, Object> getPortalOutsideUrl()
    {
        if (!portalUrlInitial)
        {
            initPortalUrl();
        }
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put("httpUrl", this.httpUrl);
        result.put("httpsUrl", this.httpsUrl);
        return result;
    }
    
    private void initPortalUrl()
    {
        String ip = ConfigFacade.getInstance().getConfig("portal.outside.domain");
        int port = ConfigFacade.getInstance().getConfigAsInteger("portal.outside.port", 80);
        int sslPort = ConfigFacade.getInstance().getConfigAsInteger("portal.outside.ssport", 443);
        String contextPath = ConfigFacade.getInstance().getConfig("portal.outside.contextpath");
        String tempHttpUrl = "http://" + ip;
        String tempHttpsUrl = "https://" + ip;
        if (port != 80)
        {
            tempHttpUrl += ":" + port;
        }
        tempHttpUrl += StringUtils.isEmpty(contextPath) ? "" : "/" + contextPath;
        
        if (sslPort != 443)
        {
            tempHttpsUrl += ":" + sslPort;
        }
        tempHttpsUrl += StringUtils.isEmpty(contextPath) ? "" : "/" + contextPath;
        this.httpUrl = tempHttpUrl;
        this.httpsUrl = tempHttpsUrl;
        portalUrlInitial = true;
    }
}
