package com.brave.backend.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class SessionHolder
{
    private static final ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();
    
    private static final ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    
    public static void setSession(HttpSession httpSession)
    {
        session.set(httpSession);
    }
    
    public static HttpSession getSession()
    {
        return session.get();
    }
    
    public static void setRequest(HttpServletRequest httpServletRequest)
    {
        request.set(httpServletRequest);
    }
    
    public static HttpServletRequest getRequest()
    {
        return request.get();
    }
    
}
