package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.model.RuleManager;

/**
 * Home object for domain model class RuleManager.
 * @see com.voyagerproject.model.RuleManager
 * @author Hibernate Tools
 */
@Stateless
public class RuleManagerDAO extends VoyagerDAO implements IVoyagerDao<RuleManager> {

	private static final Log log = LogFactory.getLog(RuleManagerDAO.class);

	public void persist(RuleManager transientInstance) {
		log.debug("persisting RuleManager instance");
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

	public void remove(RuleManager persistentInstance) {
		log.debug("removing RuleManager instance");
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

	public RuleManager merge(RuleManager detachedInstance) {
		log.debug("merging RuleManager instance");
		try {
			getEntityManager().getTransaction().begin();
			RuleManager result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
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
			RuleManager instance = getEntityManager().find(RuleManager.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
