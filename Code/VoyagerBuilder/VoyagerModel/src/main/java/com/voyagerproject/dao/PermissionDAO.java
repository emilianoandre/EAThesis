package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.model.Permission;

/**
 * Home object for domain model class Permission.
 * @see com.voyagerproject.model.Permission
 * @author Hibernate Tools
 */
@Stateless
public class PermissionDAO extends VoyagerDAO implements IVoyagerDao<Permission> {

	private static final Log log = LogFactory.getLog(PermissionDAO.class);

	public void persist(Permission transientInstance) {
		log.debug("persisting Permission instance");
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

	public void remove(Permission persistentInstance) {
		log.debug("removing Permission instance");
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

	public Permission merge(Permission detachedInstance) {
		log.debug("merging Permission instance");
		try {
			getEntityManager().getTransaction().begin();
			Permission result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Permission findById(int id) {
		log.debug("getting Permission instance with id: " + id);
		try {
			Permission instance = getEntityManager().find(Permission.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
