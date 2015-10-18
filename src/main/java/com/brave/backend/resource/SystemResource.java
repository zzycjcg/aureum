package com.brave.backend.resource;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brave.backend.dao.model.Config;

/**
 * The Interface SystemResource.
 *
 * @author zhiyong zhu at 2015-10-18
 * @since v0.0.1
 */
@Path("system")
public interface SystemResource
{
    
    /**
     * Gets the config.
     *
     * @return the config
     */
    @GET
    @Path("get/config")
    @Produces(MediaType.APPLICATION_JSON)
    List<Config> getConfig(List<String> configNameList);
    
    /**
     * Adds the config.
     *
     * @param configs the configs
     * @return the map
     */
    @POST
    @Path("add/config")
    @Produces(MediaType.APPLICATION_JSON)
    void addConfig(List<Config> configs);
    
    /**
     * Gets the portal outside url.
     *
     * @return the portal outside url
     */
    @GET
    @Path("portal/outsideUrl")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getPortalOutsideUrl();
}
