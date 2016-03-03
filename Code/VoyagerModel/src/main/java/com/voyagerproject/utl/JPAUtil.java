/**
 * @author EAndre
 *
 */
package com.voyagerproject.utl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class JPAUtil {
	
	private static final Logger log = Logger.getLogger(JPAUtil.class);
	
    private static EntityManagerFactory emf;
    
    /**
     * Gets the entity manager factory used by the system
     * 
     * @return EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {	    
        try {
    	   if (emf == null)
    	   {
    	      emf = Persistence.createEntityManagerFactory("VoyagerModel");
    	   }
        } catch (Throwable ex) {
        	log.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
        return emf;
    }
}
