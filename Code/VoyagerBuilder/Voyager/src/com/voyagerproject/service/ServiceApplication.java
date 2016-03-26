package com.voyagerproject.service;


import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.voyagerproject.service.filters.AuthenticationFilter;
 
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
 
        //Register Filters here
        register(AuthenticationFilter.class);
        register(LoggingFilter.class);
    }
}
