package com.voyagerproject.domain.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.UserDAO;
import com.voyagerproject.domain.controller.interfaces.IVoyagerDomainController;
import com.voyagerproject.domain.entities.DomainUser;
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
			log.error(ex.getStackTrace());
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
			log.error("Failed to create user with userName: " + userName);
			log.error(ex.getStackTrace());
			
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
			log.error("Failed to delete user with userName: " + userName);
			log.error(ex.getStackTrace());
			
			throw ex;
		}
	}
}
