package com.lance.web_forum.connection;

import java.sql.Connection;

public class DBConnection {
	private static Connection connection;
	static { 
		try {
			connection = DBConnectionFactory.getLocalDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getInstance() {
		return connection;
	}
}
