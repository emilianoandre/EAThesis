package com.voyagerproject.domain.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.UserDAO;
import com.voyagerproject.domain.controller.interfaces.IVoyagerDomainController;
import com.voyagerproject.domain.entities.DomainUser;
import com.voyagerproject.exceptions.ResultNotFoundException;
import com.voyagerproject.model.User;
import com.voyagerproject.model.UserType;
import com.voyagerproject.util.DomainUtil;

/**
 * @author EAndre
 *
 */
public class UserController implements IVoyagerDomainController{

	// DAOs
	UserDAO userDao = new UserDAO();
	
	private static final Log log = LogFactory.getLog(UserController.class);
	
	/**
	 * Validates the log in of the user in the system
	 * 
	 * @param userName
	 * @param password
	 * @return DomainUser logged in user 
	 */
	public DomainUser logIn(String userName, String password) {
		// Calculate password hash
		String hashedPassword = DomainUtil.calculateHash(password);
		DomainUser loggedUser = null;
		try {
			// Log in user
			loggedUser = new DomainUser(userDao.logIn(userName, hashedPassword));
		} catch (Exception ex) {
			log.error("Failed to log in user: " + userName, ex);
		}
		return loggedUser;
	}
	
	/**
	 * Creates a user in the system
	 * 
	 * @param userName
	 * @param name
	 * @param email
	 * @param password
	 * @param userTypeId
	 * @param createdBy
	 * @return createdUser
	 */
	public User createUser(String userName, String name, String email, String password, int userTypeId, String createdBy) {

		// Create User
		UserType userType = new UserType();
		userType.setIdUserType(userTypeId);
		User user = new User(userName, name, email, DomainUtil.calculateHash(password), userType, null, createdBy);
		try {
			userDao.persist(user);
			user.setIdUser(userDao.findIdByUserName(userName));
		} catch (Exception ex) {
			log.error("Failed to create user with userName: " + userName, ex);			
			return null;
		}	
		
		return user;
	}
	
	/**
	 * Deletes a user by it's userName
	 * 
	 * @param userName
	 * @throws Exception 
	 */
	public void deleteUser(String userName) throws Exception {
		try {
			userDao.deleteByUserName(userName);
		} catch (Exception ex) {
			log.error("Failed to delete user with userName: " + userName, ex);			
			throw ex;
		}
	}
	
	/**
	 * Updates a user
	 * 
	 * @param DomainUser user
	 * @return DomainUser updatedUser
	 * @throws Exception 
	 */
	public void updateUser(DomainUser updatedUser) throws Exception {
		try {
			User user;
			try {
				// First we look for the user by the userName
				user = userDao.findByUserName(updatedUser.getUserName());
			} catch (ResultNotFoundException rnfe) {
				log.info("No user found with userName: " + updatedUser.getUserName());
				user = null;
			}
			
			// Encode the password
			updatedUser.setPassword(DomainUtil.calculateHash(updatedUser.getPassword()));
			// Update the entry values and merge
			user =  DomainUser.createUserFromDomainUser(updatedUser, user);
			userDao.merge(user);
		} catch (Exception ex) {
			log.error("Failed to update user with userName: " + updatedUser.getUserName(), ex);			
			throw ex;
		}
	}
}
