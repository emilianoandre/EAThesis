package com.voyagerproject.service.utils;

import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;

/**
 * Contains the Utils for Stormpath
 * @author EAndre
 *
 */
public class StormpathUtils {

	public static Client client = Clients.builder().build();
	public static String applicationHref = "https://api.stormpath.com/v1/applications/1SgfkuONwIyxJdH1wGj3m3";
}
