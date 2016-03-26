package com.voyagerproject.service.filters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
 
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
 
import org.glassfish.jersey.internal.util.Base64;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountCriteria;
import com.stormpath.sdk.account.Accounts;
import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.api.ApiKeyList;
import com.stormpath.sdk.application.Application;
import com.voyagerproject.domain.controller.UserController;
import com.voyagerproject.domain.entities.DomainUser;
import com.voyagerproject.service.utils.StormpathUtils;

/**
 * @author EAndre
 * 
 * This filter verify the access permissions for a user
 * based on username and passowrd provided in request
 * */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter
{
     
    @Context
    private ResourceInfo resourceInfo;
     
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
                                                        .entity("You cannot access this resource").build();
    private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
                                                        .entity("Access blocked for all users !!").build();
      
    @Override
    public void filter(ContainerRequestContext requestContext)
    {
        Method method = resourceInfo.getResourceMethod();
        //Access allowed for all
        if( ! method.isAnnotationPresent(PermitAll.class))
        {
            //Access denied for all
            if(method.isAnnotationPresent(DenyAll.class))
            {
                requestContext.abortWith(ACCESS_FORBIDDEN);
                return;
            }
            
            //Get request headers
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
            
            final String accountHref = requestContext.getCookies().get("accountHref").getValue();
            
            //Fetch authorization header
            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
              
            //If no authorization information present; block access
            if(authorization == null || authorization.isEmpty())
            {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }
              
            //Get encoded username and password
            final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
              
            //Decode username and password
            String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));;
  
            //Split username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
            final String apiKey = tokenizer.nextToken();
            final String apiSecret = tokenizer.nextToken();
            
            //Verify user access
            if(method.isAnnotationPresent(RolesAllowed.class))
            {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
                  
                //Is user valid?
                if( ! isUserAllowed(accountHref, apiKey, apiSecret, rolesSet))
                {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
            }
        }
    }
    
    /**
     * Validates if the user is enabled to use the WS
     * 
     * @param userName
     * @param password
     * @param rolesSet
     * @return
     */
    private boolean isUserAllowed(final String accountHref, final String apiKey, final String apiSecret, final Set<String> rolesSet)
    {
        boolean isAllowed = false;
        
        Account account = StormpathUtils.client.getResource(accountHref, Account.class);

        ApiKeyList apiKeyList = account.getApiKeys();

        //If account already has an API Key
        for(Iterator<ApiKey> iter = apiKeyList.iterator(); iter.hasNext();) {
        	ApiKey element = iter.next();
        	if (apiKey.equals(element.getId()) && apiSecret.equals(element.getSecret())) {
        		isAllowed = true;
        	}
        }
        
        return isAllowed;
    }
}