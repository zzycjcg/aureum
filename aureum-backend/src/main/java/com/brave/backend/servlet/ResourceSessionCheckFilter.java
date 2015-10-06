package com.brave.backend.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.brave.backend.util.SessionHolder;

public class ResourceSessionCheckFilter implements Filter
{
    
    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        SessionHolder.setRequest((HttpServletRequest)request);
        SessionHolder.setSession(((HttpServletRequest)request).getSession());
        // MUST why?
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy()
    {
    }
    
}
