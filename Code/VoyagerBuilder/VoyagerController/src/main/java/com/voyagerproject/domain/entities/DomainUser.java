package com.voyagerproject.domain.entities;

import com.voyagerproject.model.User;

/**
 * Domain User Class
 *
 * @author EAndre
 *
 */
public class DomainUser {

	private int idUser;
	private String userName;
	private String name;
	private String email;
	private String password;
	private DomainUserType userType;

	public DomainUser() {
	}

	public DomainUser(int idUser, String userName, String name, String email, String password, DomainUserType userType) {
		this.idUser = idUser;
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	public DomainUser(String userName, String name, String email, String password, DomainUserType userType) {
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	/**
	 * Creates a DomainUser from a model user
	 * 
	 * @param user
	 */
	public DomainUser(User user) {
		this.idUser = user.getIdUser();
		this.userName = user.getUserName();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		
		DomainUserType userType = new DomainUserType(user.getUserType().getIdUserType(), user.getUserType().getName());
		this.userType = userType;
	}
	
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public DomainUserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(DomainUserType userType) {
		this.userType = userType;
	}
	
}
