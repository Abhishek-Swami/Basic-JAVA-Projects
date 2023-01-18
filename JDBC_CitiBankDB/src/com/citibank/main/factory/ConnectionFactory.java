package com.citibank.main.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		
	private String driverName="com.mysql.cj.jdbc.Driver";
	private	String url="jdbc:mysql://localhost:3306/citibankdb";
	private String userID="root";
	private String password="root";
	private Connection connection;
	
	
	public Connection getConnection() {
		
		try {
			Class.forName(driverName);
			connection=DriverManager.getConnection(url, userID, password);
			System.out.println("Connection Succesful");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Failed to Get DB2 Connection");
		}
		
		return null;
	}

}
