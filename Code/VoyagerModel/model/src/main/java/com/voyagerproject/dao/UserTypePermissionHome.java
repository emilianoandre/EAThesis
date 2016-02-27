package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.UserTypePermission;

/**
 * Home object for domain model class UserTypePermission.
 * @see com.voyagerproject.model.UserTypePermission
 * @author Hibernate Tools
 */
@Stateless
public class UserTypePermissionHome {

	private static final Log log = LogFactory.getLog(UserTypePermissionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserTypePermission transientInstance) {
		log.debug("persisting UserTypePermission instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserTypePermission persistentInstance) {
		log.debug("removing UserTypePermission instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserTypePermission merge(UserTypePermission detachedInstance) {
		log.debug("merging UserTypePermission instance");
		try {
			UserTypePermission result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserTypePermission findById(int id) {
		log.debug("getting UserTypePermission instance with id: " + id);
		try {
			UserTypePermission instance = entityManager.find(UserTypePermission.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
