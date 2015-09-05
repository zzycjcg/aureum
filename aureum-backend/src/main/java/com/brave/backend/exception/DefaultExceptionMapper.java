package com.brave.backend.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <描述.>
 *
 * @author 	ZZY
 * @date 	2015年9月5日
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable>
{
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionMapper.class);
    
    /** {@inheritDoc} */
    
    @Override
    public Response toResponse(Throwable e)
    {
        // web app exception return its origin response
        if (e instanceof WebApplicationException)
        {
            return ((WebApplicationException)e).getResponse();
        }
        
        log.error("Handle resource failed.", e);
        
        // other runtime exception return 500
        if (e instanceof RuntimeException)
        {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        // handle custom exception if defined.
        return Response.ok(e, MediaType.APPLICATION_JSON_TYPE).build();
    }
    
}
