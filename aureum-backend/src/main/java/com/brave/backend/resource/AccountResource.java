package com.brave.backend.resource;

public interface AccountResource
{
    void transfer(String out, String in, double num);
}
