/*
 * 文 件 名:  ConfigurableDataSource.java
 * 版    权:  zhuzhiyong Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZZY
 * 修改时间:  2015年6月7日
 * 修改内容:  <修改内容>
 */
package com.brave.foundation.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.FactoryBean;

import com.brave.foundation.util.AESUtil;

/**
 * A factory for creating ConfigurableDataSource objects.
 */
public class ConfigurableDataSourceFactory implements FactoryBean<DataSource>
{
    /** The data source properties. */
    protected Properties dataSourceProperties;
    
    /**
     * Gets the data source properties.
     *
     * @return the data source properties
     */
    public Properties getDataSourceProperties()
    {
        return dataSourceProperties;
    }
    
    /**
     * Sets the data source properties.
     *
     * @param dataSourceProperties the new data source properties
     */
    public void setDataSourceProperties(Properties dataSourceProperties)
    {
        this.dataSourceProperties = dataSourceProperties;
    }
    
    /** {@inheritDoc} */
    
    public DataSource getObject()
        throws Exception
    {
        return BasicDataSourceFactory.createDataSource(getCustomizedProperties());
    }
    
    /** {@inheritDoc} */
    
    public Class<?> getObjectType()
    {
        return DataSource.class;
    }
    
    /** {@inheritDoc} */
    
    public boolean isSingleton()
    {
        return true;
    }
    
    /**
     * Gets the customized properties.
     *
     * @return the customized properties
     */
    protected Properties getCustomizedProperties()
    {
        return decryptPassword(getDataSourceProperties());
    }
    
    /**
     * Decrypt password.
     *
     * @param properties the properties
     * @return the properties
     */
    protected Properties decryptPassword(final Properties properties)
    {
        String password = properties.getProperty("password");
        properties.put("password", AESUtil.decrypt(password, AESUtil.DEFAULT_KEY));
        return properties;
    }
    
}
