package com.voyagerproject.dao;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.voyagerproject.dao.interfaces.IVoyagerDao;
import com.voyagerproject.model.Project;

/**
 * Home object for domain model class Project.
 * @see com.voyagerproject.model.Project
 * @author Hibernate Tools
 */
@Stateless
public class ProjectDAO extends VoyagerDAO implements IVoyagerDao<Project> {

	private static final Log log = LogFactory.getLog(ProjectDAO.class);

	public void persist(Project transientInstance) {
		log.debug("persisting Project instance");
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

	public void remove(Project persistentInstance) {
		log.debug("removing Project instance");
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

	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			getEntityManager().getTransaction().begin();
			Project result = getEntityManager().merge(detachedInstance);
			getEntityManager().getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Project findById(int id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = getEntityManager().find(Project.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
