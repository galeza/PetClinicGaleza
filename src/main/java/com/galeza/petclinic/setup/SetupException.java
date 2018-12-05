package com.galeza.petclinic.setup;

import com.galeza.petclinic.base.BaseTest;

public class SetupException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SetupException(String message){
		super(message);
		BaseTest.LOG.fatal(message);
	}
	
    public SetupException(String message, Throwable cause) {
        super(message, cause);
        BaseTest.LOG.fatal(message, cause);
    }

    public SetupException(Throwable cause) {
        super(cause);
        BaseTest.LOG.fatal(cause);
    }
}
