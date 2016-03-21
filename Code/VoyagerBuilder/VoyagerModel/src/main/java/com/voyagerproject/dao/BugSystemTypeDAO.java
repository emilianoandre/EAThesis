package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.model.BugSystemType;

/**
 * Home object for domain model class BugSystemType.
 * @see com.voyagerproject.model.BugSystemType
 * @author Hibernate Tools
 */
@Stateless
public class BugSystemTypeDAO extends VoyagerDAO implements IVoyagerDao<BugSystemType> {

	private static final Log log = LogFactory.getLog(BugSystemTypeDAO.class);

	public void persist(BugSystemType transientInstance) {
		log.debug("persisting BugSystemType instance");
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

	public void remove(BugSystemType persistentInstance) {
		log.debug("removing BugSystemType instance");
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

	public BugSystemType merge(BugSystemType detachedInstance) {
		log.debug("merging BugSystemType instance");
		try {
			getEntityManager().getTransaction().begin();
			BugSystemType result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
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
			BugSystemType instance = getEntityManager().find(BugSystemType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
