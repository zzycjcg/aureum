package com.brave.backend.resource;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.brave.backend.dao.model.Config;

/**
 * The Interface SystemResource.
 */
@Path("system")
public interface SystemResource
{
    
    /**
     * Gets the config.
     *
     * @param configName the config name
     * @return the config
     */
    @GET
    @Path("get/config")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getConfig(@QueryParam("configName") String configName);
    
    /**
     * Adds the config.
     *
     * @param configName the config name
     * @param configValue the config value
     * @return the map
     */
    @POST
    @Path("add/config")
    @Produces(MediaType.APPLICATION_JSON)
    void addConfig(List<Config> configs);
    
    @GET
    @Path("portal/outsideUrl")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getPortalOutsideUrl();
}
