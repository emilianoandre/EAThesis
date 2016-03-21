package com.voyagerproject.dao;

import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

import com.voyagerproject.util.JPAUtil;

public abstract class VoyagerDAO {
	
	private static final Logger log = Logger.getLogger(VoyagerDAO.class);
			
	private EntityManager entityManager;
	
	/**
	 * Returns the entity manager for the entity
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		
        try {
    	   if (entityManager == null)
    	   {
    		   entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    	   }
        } catch (Throwable ex) {
        	log.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        return entityManager;
	}

}
