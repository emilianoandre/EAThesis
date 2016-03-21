package com.voyagerproject.domain.controller.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.Test;

import com.voyagerproject.domain.controller.UserController;
import com.voyagerproject.exceptions.ResultNotFoundException;
import com.voyagerproject.model.User;

/**
 * @author EAndre
 *
 */
public class UserControllerTest {
	
	private static final Log log = LogFactory.getLog(UserControllerTest.class);
	
	UserController userController = new UserController();
	
	@Rule
	public ModelTestWatcher testWatcher = new ModelTestWatcher();
    
    /**
     * Tests the user creation
     */
    public void createUserTest()
    {
    	User user = userController.createUser("TestUserName", "Name", "email", "testPassword", 1, "eandre");
        assertNotNull(user);
    }
    
    /**
     * Tests the duplicate user creation
     */
    @Test
    public void createDuplicateUserTest()
    {
    	User user = new User();
    	try{
    		user = userController.createUser("TestUserNameNonDelete", "Name", "email", "testPassword", 1, "eandre");
    	} catch (Exception ex) {
    		log.debug("createDuplicateUserTest: Exception " + ex.getMessage());
    	}
    	assertNull(user);
    }
    
    /**
     * Tests the user deletion
     */
    
    public void deleteUserTest()
    {
    	try {
    		userController.deleteUser("TestUserName");
    	} catch (Exception ex) {
    	  fail(ex.getMessage());
    	}
    	assertTrue(true);
    }
    
    /**
     * Tests the user deletion failure
     * @throws Exception 
     */
    @Test(expected = ResultNotFoundException.class)
    public void deleteUserWrongUserNameTest() throws Exception
    {
    	userController.deleteUser("TestUserName2");
    }
    
    /**
     * Log in user test
     * 
     */
    @Test
    public void logInTest() {
    	userController.logIn("TestUserNameNonDelete", "testPassword");
    }
    
    /**
     * Incorrect Log in test
     * 
     */
    public void logInFailedTest() {
    	assertNull(userController.logIn("TestUserNameNonDelete", "testPassword2"));
    }

}
