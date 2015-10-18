package com.brave.backend.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brave.backend.resource.message.CheckAccountExistanceRequest;
import com.brave.backend.resource.message.CheckAccountExistanceResponse;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.resource.message.LogoutResponse;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;

/**
 * The Interface UserResource.
 */
@Path("user")
public interface UserResource
{
    
    /**
     * Login.
     *
     * @param loginRequest the login request
     * @return the login response
     */
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    LoginResponse login(LoginRequest loginRequest);
    
    /**
     * Logout.
     *
     * @return the logout response
     */
    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    LogoutResponse logout();
    
    /**
     * Register.
     *
     * @param registerRequest the register request
     * @return the register response
     */
    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    RegisterResponse register(RegisterRequest registerRequest);
    
    /**
     * Checks if is username taken.
     *
     * @param checkAccountRequest the check account request
     * @return true, if is username taken
     */
    @POST
    @Path("check/accountName")
    @Produces(MediaType.APPLICATION_JSON)
    CheckAccountExistanceResponse checkAccountNameExistance(CheckAccountExistanceRequest checkAccountRequest);
}
