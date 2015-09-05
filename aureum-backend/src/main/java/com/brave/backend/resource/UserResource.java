package com.brave.backend.resource;

import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Interface UserResource.
 */
@Path("user")
public interface UserResource
{
    
    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     */
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    void login(@FormParam("username") String username, @FormParam("password") String password);
    
    /**
     * Logout.
     */
    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    void logout();
    
    /**
     * Register.
     *
     * @param username the username
     * @param password the password
     */
    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    void register(@FormParam("username") String username, @FormParam("password") String password);
    
    /**
     * Checks if is username taken.
     *
     * @param username the username
     * @return true, if is username taken
     */
    @POST
    @Path("check/username")
    @Produces(MediaType.APPLICATION_JSON)
    boolean isUsernameTaken(@FormParam("username") String username);
    
    /**
     * Delete.
     *
     * @param username the username
     */
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    void delete(@FormParam("username") String username);
    
    /**
     * Gets the captcha.
     *
     * @return the captcha
     */
    @GET
    @Path("captcha/get")
    @Produces("image/png")
    byte[] getCaptcha();
    
    /**
     * Varify captcha.
     *
     * @param captcha the captcha
     * @return the map
     */
    @POST
    @Path("captcha/varification")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> varifyCaptcha(@FormParam("captcha") String captcha);
}
