package com.brave.backend.resource.impl;

import com.brave.backend.resource.UserResource;
import com.brave.backend.resource.impl.service.CheckAccountNameExistanceService;
import com.brave.backend.resource.impl.service.LoginService;
import com.brave.backend.resource.impl.service.LogoutService;
import com.brave.backend.resource.impl.service.RegisterService;
import com.brave.backend.resource.message.CheckAccountExistanceRequest;
import com.brave.backend.resource.message.CheckAccountExistanceResponse;
import com.brave.backend.resource.message.LoginRequest;
import com.brave.backend.resource.message.LoginResponse;
import com.brave.backend.resource.message.LogoutResponse;
import com.brave.backend.resource.message.RegisterRequest;
import com.brave.backend.resource.message.RegisterResponse;

/**
 * The Class UserResourceImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class UserResourceImpl implements UserResource
{
    
    /** {@inheritDoc} */
    
    @Override
    public LoginResponse login(LoginRequest loginRequest)
    {
        return LoginService.getInstance().execute(loginRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public LogoutResponse logout()
    {
        return LogoutService.getInstance().execute();
    }
    
    /** {@inheritDoc} */
    
    @Override
    public RegisterResponse register(RegisterRequest registerRequest)
    {
        return RegisterService.getInstance().execute(registerRequest);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public CheckAccountExistanceResponse checkAccountNameExistance(CheckAccountExistanceRequest checkAccountRequest)
    {
        return CheckAccountNameExistanceService.getInstace().execute(checkAccountRequest);
    }
    
}
