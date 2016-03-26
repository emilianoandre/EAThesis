package com.voyagerproject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.api.ApiKeyList;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.UsernamePasswordRequest;
import com.stormpath.sdk.resource.ResourceException;
import com.voyagerproject.domain.controller.UserController;
import com.voyagerproject.service.utils.StormpathUtils;

 
/**
 * @author EAndre
 *
 */
@Path("/Login")
public class LoginService {
	
	private static final Log log = LogFactory.getLog(LoginService.class);
	
	UserController userController = new UserController();
	@Context
    private HttpServletResponse servletResponse;
	
	/**
	 * Login service
	 * 
	 * @param String user
	 * @param String password
	 * @return String 
	 * @throws IOException 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	@PermitAll
	public void login(@HeaderParam("userName") String userName, @HeaderParam("password") String password) throws IOException {
		
		// Log into de DB
		try {
			userController.logIn(userName, password);
		} catch (Exception ex) {
			log.error("Failed to authenticate user", ex);
            servletResponse.sendError(401);
            return;
		}
		
		Application application = StormpathUtils.client.getResource(StormpathUtils.applicationHref, Application.class);

        @SuppressWarnings("rawtypes")
		AuthenticationRequest request = UsernamePasswordRequest.builder()
        	    .setUsernameOrEmail(userName)
        	    .setPassword(password)
        	    .build();
        Account authenticated;

        //Try to authenticate the account
        try {
            authenticated = application.authenticateAccount(request).getAccount();
        } catch (ResourceException e) {
            System.out.println("Failed to authenticate user");
            servletResponse.sendError(401);
            return;
        }         
        
        Cookie myCookie = new Cookie("accountHref", authenticated.getHref());
        myCookie.setMaxAge(60 * 60);
        myCookie.setPath("/");
        myCookie.setHttpOnly(true);
        servletResponse.addCookie(myCookie);
	}
	
	/**
	 * Returns the apiKey for the user to be used by the UI
	 * 
	 * @param accountHref
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	@Path("/getApiKey")
	public GenericEntity getApiKey(@CookieParam("accountHref") String accountHref) throws Exception {

        Account account = StormpathUtils.client.getResource(accountHref, Account.class);

        ApiKeyList apiKeyList = account.getApiKeys();

        boolean hasApiKey = false;
        String apiKeyId = "";
        String apiSecret = "";

        //If account already has an API Key
        for(Iterator<ApiKey> iter = apiKeyList.iterator(); iter.hasNext();) {
            hasApiKey = true;
            ApiKey element = iter.next();
            apiKeyId = element.getId();
            apiSecret = element.getSecret();
        }
        
        //If account doesn't have an API Key, generate one
        if(hasApiKey == false) {
            ApiKey newApiKey = account.createApiKey();
            apiKeyId = newApiKey.getId();
            apiSecret = newApiKey.getSecret();
        }

        //Get the username of the account
        String username = account.getUsername();

        //Make a JSON object with the key and secret to send back to the client
        Map<String, String> response = new HashMap<>();

        response.put("api_key", apiKeyId);
        response.put("api_secret", apiSecret);
        response.put("username", username);
        
        @SuppressWarnings("unchecked")
		GenericEntity<Map<String, String>> responseEntity = new GenericEntity(response, Map.class);
        
        return responseEntity;
    }
}
