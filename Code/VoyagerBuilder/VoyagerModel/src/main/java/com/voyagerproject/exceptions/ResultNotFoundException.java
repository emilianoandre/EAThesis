package com.voyagerproject.exceptions;

/**
 * ResultNotFoundException to be thrown to the Controller
 * 
 * @author EAndre
 *
 */
public class ResultNotFoundException extends Exception {

	private static final long serialVersionUID = 3619780169369589848L;
	
	/**
	 * Constructs the new exception with a specified message
	 * 
	 */
	public ResultNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Constructs the new exception from another exception
	 * 
	 */
	public ResultNotFoundException(Exception ex) {
		super(ex);
	}

}
