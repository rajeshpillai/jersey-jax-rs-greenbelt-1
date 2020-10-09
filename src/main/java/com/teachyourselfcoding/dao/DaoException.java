package com.teachyourselfcoding.dao;

public class DaoException extends Exception {
	private static final long serialVersionUID = 469646951222786617L;

	public DaoException() {
		super();
	}
		
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(Throwable cause) {
		super(cause);
	}
	
}
