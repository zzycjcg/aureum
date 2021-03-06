package com.brave.backend.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The Class SessionHolder.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
 */
public abstract class SessionHolder
{
    private static final ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();
    
    private static final ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    
    /**
     * Sets the session.
     *
     * @param httpSession the new session
     */
    public static void setSession(HttpSession httpSession)
    {
        session.set(httpSession);
    }
    
    /**
     * Gets the session.
     *
     * @return the session
     */
    public static HttpSession getSession()
    {
        return session.get();
    }
    
    /**
     * Sets the request.
     *
     * @param httpServletRequest the new request
     */
    public static void setRequest(HttpServletRequest httpServletRequest)
    {
        request.set(httpServletRequest);
    }
    
    /**
     * Gets the request.
     *
     * @return the request
     */
    public static HttpServletRequest getRequest()
    {
        return request.get();
    }
    
}
