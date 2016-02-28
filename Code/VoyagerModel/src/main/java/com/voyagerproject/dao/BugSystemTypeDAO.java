package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.BugSystemType;

/**
 * Home object for domain model class BugSystemType.
 * @see com.voyagerproject.model.BugSystemType
 * @author Hibernate Tools
 */
@Stateless
public class BugSystemTypeDAO {

	private static final Log log = LogFactory.getLog(BugSystemTypeDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(BugSystemType transientInstance) {
		log.debug("persisting BugSystemType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BugSystemType persistentInstance) {
		log.debug("removing BugSystemType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BugSystemType merge(BugSystemType detachedInstance) {
		log.debug("merging BugSystemType instance");
		try {
			BugSystemType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BugSystemType findById(int id) {
		log.debug("getting BugSystemType instance with id: " + id);
		try {
			BugSystemType instance = entityManager.find(BugSystemType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
