package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.RuleManagerType;

/**
 * Home object for domain model class RuleManagerType.
 * @see com.voyagerproject.model.RuleManagerType
 * @author Hibernate Tools
 */
@Stateless
public class RuleManagerTypeDAO extends VoyagerDAO {

	private static final Log log = LogFactory.getLog(RuleManagerTypeDAO.class);

	public void persist(RuleManagerType transientInstance) {
		log.debug("persisting RuleManagerType instance");
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

	public void remove(RuleManagerType persistentInstance) {
		log.debug("removing RuleManagerType instance");
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

	public RuleManagerType merge(RuleManagerType detachedInstance) {
		log.debug("merging RuleManagerType instance");
		try {
			getEntityManager().getTransaction().begin();
			RuleManagerType result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
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
			RuleManagerType instance = getEntityManager().find(RuleManagerType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
