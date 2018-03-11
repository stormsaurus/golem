/**
 * Copyright 2008 James Teer
 */

package io.james.golem;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	
    public UserException(String message){
        super(message);
	}
	
    public UserException(String message, Throwable e){
        super(message,e );
    }
}
