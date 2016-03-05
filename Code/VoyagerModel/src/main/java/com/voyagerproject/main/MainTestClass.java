package com.voyagerproject.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.voyagerproject.dao.UserDAO;
import com.voyagerproject.dao.UserTypeDAO;
import com.voyagerproject.model.User;
import com.voyagerproject.model.UserType;

/**
 * Hello world!
 *
 */
public class MainTestClass 
{
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
    public static void main( String[] args )
    {
    	initEntityManager();
        UserType userType = new UserType("admin", null, "eandre");
        UserTypeDAO userTypeDAO = new UserTypeDAO();
        userTypeDAO.persist(userType);
        
        User user = new User("userName", "name", "email", "password", userType, null, "eandre");
        UserDAO userDao = new UserDAO();
        //userDao.persist(user);
        closeEntityManager();
    }
    
    private static void initEntityManager() {
        emf = Persistence.createEntityManagerFactory("VoyagerModel");
        em = emf.createEntityManager();
    }
     
    private static void closeEntityManager() {
        em.close();
        emf.close();
    }
}
