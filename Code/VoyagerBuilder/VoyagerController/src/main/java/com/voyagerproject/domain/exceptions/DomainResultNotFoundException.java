package com.voyagerproject.domain.exceptions;

/**
 * ResultNotFoundException to be thrown
 * 
 * @author EAndre
 *
 */
public class DomainResultNotFoundException extends Exception {

	private static final long serialVersionUID = 3619780169369589848L;
	
	/**
	 * Constructs the new exception with a specified message
	 * 
	 */
	public DomainResultNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Constructs the new exception from another exception
	 * 
	 */
	public DomainResultNotFoundException(Exception ex) {
		super(ex);
	}

}
