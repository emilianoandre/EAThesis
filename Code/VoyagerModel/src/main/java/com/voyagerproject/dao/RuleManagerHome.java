package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.RuleManager;

/**
 * Home object for domain model class RuleManager.
 * @see com.voyagerproject.model.RuleManager
 * @author Hibernate Tools
 */
@Stateless
public class RuleManagerHome {

	private static final Log log = LogFactory.getLog(RuleManagerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RuleManager transientInstance) {
		log.debug("persisting RuleManager instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RuleManager persistentInstance) {
		log.debug("removing RuleManager instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RuleManager merge(RuleManager detachedInstance) {
		log.debug("merging RuleManager instance");
		try {
			RuleManager result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RuleManager findById(int id) {
		log.debug("getting RuleManager instance with id: " + id);
		try {
			RuleManager instance = entityManager.find(RuleManager.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
