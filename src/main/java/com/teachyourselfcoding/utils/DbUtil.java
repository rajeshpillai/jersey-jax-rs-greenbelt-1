package com.teachyourselfcoding.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
	private DbUtil() {
	}
	
	static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
	
	static String driver = rb.getString("jdbc.driver");
	static String url = rb.getString("jdbc.url");
	static String user = rb.getString("jdbc.user");
	static String password = rb.getString("jdbc.password");
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}

