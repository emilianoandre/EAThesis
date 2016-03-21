package com.voyagerproject.dao;
// Generated Feb 28, 2016 12:50:47 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.log4j.Logger;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.model.UserType;

/**
 * Home object for domain model class UserType.
 * @see com.voyagerproject.model.UserType
 * @author Hibernate Tools
 */
@Stateless
public class UserTypeDAO extends VoyagerDAO implements IVoyagerDao<UserType>{

	private static final Logger log = Logger.getLogger(UserTypeDAO.class);
	
	public void persist(UserType transientInstance) {
		log.debug("persisting UserType instance");
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

	public void remove(UserType persistentInstance) {
		log.debug("removing UserType instance");
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

	public UserType merge(UserType detachedInstance) {
		log.debug("merging UserType instance");
		try {
			getEntityManager().getTransaction().begin();
			UserType result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserType findById(int id) {
		log.debug("getting UserType instance with id: " + id);
		try {
			UserType instance = getEntityManager().find(UserType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
