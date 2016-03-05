package com.voyagerproject.domain.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.UserDAO;
import com.voyagerproject.domain.controller.interfaces.IVoyagerDomainController;
import com.voyagerproject.domain.util.DomainUtil;
import com.voyagerproject.model.User;
import com.voyagerproject.model.UserType;

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
	 * @return success
	 */
	public User logIn(String userName, String password) {
		// Calculate password hash
		String hashedPassword = DomainUtil.calculateHash(password);
		
		// Log in user
		return userDao.logIn(userName, hashedPassword);
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
