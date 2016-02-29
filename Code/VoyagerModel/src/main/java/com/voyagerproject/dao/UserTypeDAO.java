package com.voyagerproject.dao;
// Generated Feb 28, 2016 12:50:47 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

import com.voyagerproject.model.UserType;

/**
 * Home object for domain model class UserType.
 * @see com.voyagerproject.model.UserType
 * @author Hibernate Tools
 */
@Stateless
public class UserTypeDAO {

	private static final Logger log = Logger.getLogger(UserTypeDAO.class);

	@PersistenceContext(unitName = "VoyagerModel")
	private EntityManager entityManager;

	public void persist(UserType transientInstance) {
		log.debug("persisting UserType instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(transientInstance);
			entityManager.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserType persistentInstance) {
		log.debug("removing UserType instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(persistentInstance);
			entityManager.getTransaction().commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserType merge(UserType detachedInstance) {
		log.debug("merging UserType instance");
		try {
			entityManager.getTransaction().begin();
			UserType result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
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
			UserType instance = entityManager.find(UserType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
