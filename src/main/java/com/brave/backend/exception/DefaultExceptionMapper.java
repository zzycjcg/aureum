package com.brave.backend.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.brave.backend.constant.DefinedResponses;

/**
 * The Class DefaultExceptionMapper.
 *
 * @author zhiyong zhu at 2015-10-7
 * @since v0.0.1
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
        
        // 数据库异常
        if (e instanceof DataAccessException || e instanceof PersistenceException)
        {
            log.error("Failed to operate database", e);
            return Response.ok(DefinedResponses.DB_ERROR, MediaType.APPLICATION_JSON_TYPE).build();
        }
        
        // other runtime exception return 500
        if (e instanceof RuntimeException)
        {
            log.error("Handle resource failed.", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
        log.error("Handle resource failed.", e);
        // handle custom exception if defined.
        return Response.ok(DefinedResponses.UNKNOWN_ERROR, MediaType.APPLICATION_JSON_TYPE).build();
    }
    
}
