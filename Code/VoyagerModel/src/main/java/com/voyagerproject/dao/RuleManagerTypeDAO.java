package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.RuleManagerType;

/**
 * Home object for domain model class RuleManagerType.
 * @see com.voyagerproject.model.RuleManagerType
 * @author Hibernate Tools
 */
@Stateless
public class RuleManagerTypeDAO {

	private static final Log log = LogFactory.getLog(RuleManagerTypeDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RuleManagerType transientInstance) {
		log.debug("persisting RuleManagerType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RuleManagerType persistentInstance) {
		log.debug("removing RuleManagerType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RuleManagerType merge(RuleManagerType detachedInstance) {
		log.debug("merging RuleManagerType instance");
		try {
			RuleManagerType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RuleManagerType findById(int id) {
		log.debug("getting RuleManagerType instance with id: " + id);
		try {
			RuleManagerType instance = entityManager.find(RuleManagerType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
