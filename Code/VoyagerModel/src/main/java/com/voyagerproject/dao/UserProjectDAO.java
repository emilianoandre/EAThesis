package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.UserProject;

/**
 * Home object for domain model class UserProject.
 * @see com.voyagerproject.model.UserProject
 * @author Hibernate Tools
 */
@Stateless
public class UserProjectDAO extends VoyagerDAO {

	private static final Log log = LogFactory.getLog(UserProjectDAO.class);

	public void persist(UserProject transientInstance) {
		log.debug("persisting UserProject instance");
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

	public void remove(UserProject persistentInstance) {
		log.debug("removing UserProject instance");
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

	public UserProject merge(UserProject detachedInstance) {
		log.debug("merging UserProject instance");
		try {
			getEntityManager().getTransaction().begin();
			UserProject result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserProject findById(int id) {
		log.debug("getting UserProject instance with id: " + id);
		try {
			UserProject instance = getEntityManager().find(UserProject.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
