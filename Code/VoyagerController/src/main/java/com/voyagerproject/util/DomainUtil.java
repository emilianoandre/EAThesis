package com.voyagerproject.util;

import org.apache.commons.codec.digest.DigestUtils;

public class DomainUtil
{
	// Salt used to encrypt passwords
	private static String salt = "HashingSalt4545";
	
	/**
	 * Hashes a password
	 * 
	 * @param data
	 * @param salt
	 * @return hashedPassword
	 */
	public static String calculateHash(String data) {
	    return DigestUtils.sha512Hex(data + salt);
	}
}
