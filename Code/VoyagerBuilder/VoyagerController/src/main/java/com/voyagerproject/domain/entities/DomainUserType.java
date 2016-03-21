package com.voyagerproject.domain.entities;

/**
 * Domain UserType class
 * 
 * @author EAndre
 *
 */
public class DomainUserType {
	
	private int idUserType;
	private String name;

	public DomainUserType() {
	}

	public DomainUserType(int idUserType, String name) {
		this.setIdUserType(idUserType);
	}
	
	public DomainUserType(String name) {
		this.setName(name);
	}

	/**
	 * @return the idUserType
	 */
	public int getIdUserType() {
		return idUserType;
	}

	/**
	 * @param idUserType the idUserType to set
	 */
	public void setIdUserType(int idUserType) {
		this.idUserType = idUserType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
