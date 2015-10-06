package com.brave.backend.container;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * The Class ApplicationContextHolder.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public final class ApplicationContextHolder implements ApplicationContextAware
{
    private ApplicationContext applicationContext;
    
    private static ApplicationContextHolder instance;
    
    /**
     * Gets the single instance of ApplicationContextHolder.
     *
     * @return single instance of ApplicationContextHolder
     */
    public static ApplicationContextHolder getInstance()
    {
        return instance;
    }
    
    /**
     * Sets the instance.
     *
     * @param instance the new instance
     */
    protected static void setInstance(ApplicationContextHolder instance)
    {
        ApplicationContextHolder.instance = instance;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        this.applicationContext = applicationContext;
    }
    
    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
}
