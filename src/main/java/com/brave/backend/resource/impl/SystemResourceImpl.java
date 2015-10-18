package com.brave.backend.resource.impl;

import java.util.ArrayList;
import java.util.Collections;
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
import com.github.zzycjcg.foundation.dao.BaseDao;

/**
 * The Class SystemResourceImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class SystemResourceImpl implements SystemResource
{
    private static final Logger log = LoggerFactory.getLogger(SystemResourceImpl.class);
    
    private String httpUrl;
    
    private String httpsUrl;
    
    private volatile boolean portalUrlInitial = false;
    
    private BaseDao<Config> configDao;
    
    /**
     * Sets the config dao.
     *
     * @param configDao the new config dao
     */
    public void setConfigDao(BaseDao<Config> configDao)
    {
        this.configDao = configDao;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public List<Config> getConfig(List<String> configNameList)
    {
        if (CollectionUtils.isEmpty(configNameList))
        {
            return Collections.emptyList();
        }
        List<Config> configList = new ArrayList<Config>();
        for (String configName : configNameList)
        {
            // 没有值的话塞入null
            configList.add(ConfigFacade.getInstance().getConfigObject(configName));
        }
        return configList;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void addConfig(List<Config> configs)
    {
        if (CollectionUtils.isEmpty(configs))
        {
            log.warn("No need to add any config: list is null or empty.");
            return;
        }
        for (Config config : configs)
        {
            Config origin = configDao.querySingle(config.getConfigName());
            if (origin != null)
            {
                configDao.update(config);
                log.info("update config: configName={}, replace configValue:{} with {}.",
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
    
    /** {@inheritDoc} */
    
    @Override
    public Map<String, Object> getPortalOutsideUrl()
    {
        if (!portalUrlInitial)
        {
            initPortalUrl();
        }
        Map<String, Object> result = new HashMap<String, Object>();
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
