package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.BugSystem;

/**
 * Home object for domain model class BugSystem.
 * @see com.voyagerproject.model.BugSystem
 * @author Hibernate Tools
 */
@Stateless
public class BugSystemHome {

	private static final Log log = LogFactory.getLog(BugSystemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(BugSystem transientInstance) {
		log.debug("persisting BugSystem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BugSystem persistentInstance) {
		log.debug("removing BugSystem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BugSystem merge(BugSystem detachedInstance) {
		log.debug("merging BugSystem instance");
		try {
			BugSystem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BugSystem findById(int id) {
		log.debug("getting BugSystem instance with id: " + id);
		try {
			BugSystem instance = entityManager.find(BugSystem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
