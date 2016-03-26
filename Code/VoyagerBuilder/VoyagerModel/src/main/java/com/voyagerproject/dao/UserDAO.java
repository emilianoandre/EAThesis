package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.exceptions.ResultNotFoundException;
import com.voyagerproject.model.User;

/**
 * Home object for domain model class User.
 * @see com.voyagerproject.model.User
 * @author Hibernate Tools
 */
@Stateless
public class UserDAO extends VoyagerDAO implements IVoyagerDao<User> {

	private static final Log log = LogFactory.getLog(UserDAO.class);

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(transientInstance);
			getEntityManager().getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(persistentInstance);
			getEntityManager().getTransaction().commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			getEntityManager().getTransaction().begin();
			User result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
			log.debug("merge successful");
			return result;
		}catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(int id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = getEntityManager().find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * Log in a user and returned the logged user
	 * 
	 * @param userName
	 * @param password
	 * @return logged in user
	 */
	public User logIn(String userName, String password) throws ResultNotFoundException, Exception{
		log.debug("Logging in User: " + userName);
		User result = null;
		try {
			Query query = getEntityManager().createQuery("select u from User u where u.userName = '" + userName + "' and u.password = '" + password + "'");
			result = (User) query.getSingleResult();			
		} catch (NoResultException nrEx) {
			log.debug("Incorrect user name or password for User: " + userName);
			throw new ResultNotFoundException(nrEx);
		} catch (Exception ex) {
			log.debug("Failed to log in User: " + userName);
			throw ex;
		}
		return result;
	}
	
	/**
	 * Finds a user id by userName
	 * 
	 * @param String userName
	 * @return Integer userId
	 * @throws ResultNotFoundException 
	 */
	public Integer findIdByUserName(String userName) throws ResultNotFoundException {
		log.debug("Finding User: " + userName);
		Integer result = null;
		try {
			Query query = getEntityManager().createQuery("select u.idUser from User u where u.userName = '" + userName + "'");
			result = (Integer) query.getSingleResult();
			log.debug("Found User: " + userName);
		} catch (NoResultException nrEx) {
			log.debug("User: " + userName + " not found");
			throw new ResultNotFoundException(nrEx);
		} catch (Exception ex) {
			log.error("Failed find User: " + userName);
			log.error(ex.getStackTrace());
		}
		return result;
	}
	
	/**
	 * Finds a user by userName
	 * 
	 * @param String userName
	 * @return User user
	 * @throws ResultNotFoundException 
	 */
	public User findByUserName(String userName) throws ResultNotFoundException {
		log.debug("Finding User: " + userName);
		User result = null;
		try {
			Query query = getEntityManager().createQuery("select u from User u where u.userName = '" + userName + "'");
			result = (User) query.getSingleResult();
			log.debug("Found User: " + userName);
		} catch (NoResultException nrEx) {
			log.debug("User: " + userName + " not found");
			throw new ResultNotFoundException(nrEx);
		} catch (Exception ex) {
			log.error("Failed find User: " + userName);
			log.error(ex.getStackTrace());
		}
		return result;
	}
	
	/**
	 * Deletes a user by userName
	 * 
	 * @param userName
	 * @return rows deleted
	 */
	public int deleteByUserName(String userName) throws Exception {
		log.debug("Deleting User: " + userName);
		int result = 0;
		try {
			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createQuery("Delete from User u where u.userName = '" + userName + "'");
			result = query.executeUpdate();
			getEntityManager().getTransaction().commit();
			log.debug("Deleted User: " + userName);
		} catch (Exception ex) {
			log.error("Failed deleting User: " + userName);
			log.error(ex.getStackTrace());
			
			throw ex;
		}
		
		// If no entry was found to delete throw an exception
		if (result == 0) {
			throw new ResultNotFoundException("No user found with userName: " + userName);
		}
		
		return result;
	}
}
