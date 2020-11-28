package com.lance.web_forum.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	
	public static Connection getHrDBConnection() throws SQLException{
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "hr";
	    String passwd = "123456";
		Connection connection = DriverManager.getConnection(url, user, passwd);
		
		return connection;
	}
	
	public static Connection getLocalDBConnection() throws SQLException{
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "LOCAL";
	    String passwd = "root";
		Connection connection = DriverManager.getConnection(url, user, passwd);
		
		return connection;
	}
	
	public static Connection getMySqlConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/mySql_DB";
	    String user = "root";
	    String passwd = "root";
		Connection connection = DriverManager.getConnection(url, user, passwd);
		
		return connection;
	}

	public static Connection getMsSqlConnection() throws SQLException{
		String url = "jdbc:sqlserver://localhost:1433;databaseName=MS_LOCAL_DB";		
	    String user = "MS_SQL_USER";
	    String passwd = "root";
		Connection connection = DriverManager.getConnection(url, user, passwd);
		
		return connection;
	}
}

