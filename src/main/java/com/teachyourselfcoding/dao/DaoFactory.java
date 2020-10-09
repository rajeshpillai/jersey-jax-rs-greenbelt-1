package com.teachyourselfcoding.dao;

public final class DaoFactory {
	private static final String CONN_TYPE = "jdbc";
	
	private DaoFactory() {
	}
	
	public static ContactsDao getContactsDao() throws DaoException {
		switch(CONN_TYPE) {
		case "jdbc":
			return new JdbcContactsDao();
		default:
			throw new DaoException("No implementation available for DB");
		}
	}
}
