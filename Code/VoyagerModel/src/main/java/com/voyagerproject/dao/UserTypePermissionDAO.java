package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.model.UserTypePermission;

/**
 * Home object for domain model class UserTypePermission.
 * @see com.voyagerproject.model.UserTypePermission
 * @author Hibernate Tools
 */
@Stateless
public class UserTypePermissionDAO extends VoyagerDAO {

	private static final Log log = LogFactory.getLog(UserTypePermissionDAO.class);

	public void persist(UserTypePermission transientInstance) {
		log.debug("persisting UserTypePermission instance");
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

	public void remove(UserTypePermission persistentInstance) {
		log.debug("removing UserTypePermission instance");
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

	public UserTypePermission merge(UserTypePermission detachedInstance) {
		log.debug("merging UserTypePermission instance");
		try {
			getEntityManager().getTransaction().begin();
			UserTypePermission result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
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
			UserTypePermission instance = getEntityManager().find(UserTypePermission.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
