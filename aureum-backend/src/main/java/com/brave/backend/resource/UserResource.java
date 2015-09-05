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
     * @throws GeneralBraveException the general brave exception
     */
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    void login(@FormParam("username") String username, @FormParam("password") String password);
    
    /**
     * Logout.
     *
     * @throws GeneralBraveException the general brave exception
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
     * @throws GeneralBraveException the general brave exception
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
     * @throws GeneralBraveException the general brave exception
     */
    @POST
    @Path("check/username")
    @Produces(MediaType.APPLICATION_JSON)
    boolean isUsernameTaken(@FormParam("username") String username);
    
    /**
     * Delete.
     *
     * @param username the username
     * @throws GeneralBraveException the general brave exception
     */
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    void delete(@FormParam("username") String username);
    
    @GET
    @Path("captcha/get")
    @Produces("image/png")
    byte[] getCaptcha();
    
    @POST
    @Path("captcha/varification")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> varifyCaptcha(@FormParam("captcha") String captcha);
}
