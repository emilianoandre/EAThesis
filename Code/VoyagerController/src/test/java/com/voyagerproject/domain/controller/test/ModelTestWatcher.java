package com.voyagerproject.domain.controller.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * @author EAndre
 *
 */
public class ModelTestWatcher extends TestWatcher{
	
	private static final Log log = LogFactory.getLog(ModelTestWatcher.class);
	
    protected void failed(Throwable e, Description description) {
    	log.debug("Failed test: " + description.getMethodName());
    }
    
    protected void starting(Description description) {
    	log.debug("Starting test: " + description.getMethodName());
    }
    
    protected void succeeded(Description description) {
    	log.debug("Passed test: " + description.getMethodName());
    }
}
