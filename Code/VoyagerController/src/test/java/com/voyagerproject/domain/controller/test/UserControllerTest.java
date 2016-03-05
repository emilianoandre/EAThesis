package com.voyagerproject.domain.controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.voyagerproject.domain.controller.UserController;
import com.voyagerproject.model.User;

/**
 * @author EAndre
 *
 */
public class UserControllerTest {
	
	UserController userController = new UserController();
    
    /**
     * Tests the user creation
     */
    @Test
    public void createUserTest()
    {
    	User user = userController.createUser("TestUserName", "Name", "email", "testPassword", 1, "eandre");
        assertNotNull(user);
    }
    
    /**
     * Tests the user deletion
     */
    @Test
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
     * Tests the user deletion
     */
    @Test
    public void deleteUserWrontUserNameTest()
    {
    	try {
    		userController.deleteUser("TestUserName2");
    	} catch (Exception ex) {
    	  fail(ex.getMessage());
    	}
    	assertEquals(0, )
    }

}
