package com.voyagerproject.service;


import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
 
import com.voyagerproject.service.provider.AuthenticationFilter;
 
/**
 * @author EAndre
 *
 */
public class ServiceApplication extends ResourceConfig 
{
    public ServiceApplication() 
    {
        packages("com.voyagerproject.service");
        register(LoggingFilter.class);
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}
