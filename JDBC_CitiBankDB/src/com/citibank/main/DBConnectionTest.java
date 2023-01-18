package com.citibank.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnectionTest {

	public static void main(String[] args) {
		System.out.println("Main Start");
		Connection connection=null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Class Loaded Successfully");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/citibankdb","root","root");
			System.out.println("Connection Successful");
			
//	CODE FOR INSERT RECORDS
//			String query ="insert into customer_detail(name,address) values(?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			
//			for (int i = 1; i < 6; i++) {
//				System.out.println("Enter Customer "+i+" Name");
//				String name = scanner.next();
//				System.out.println("Enter Customer "+i+" Address");
//				String address = scanner.next();
//				
//				preparedStatement.setString(1, name);
//				preparedStatement.setString(2, address);
//					
//				int rowCount = preparedStatement.executeUpdate();
//				
//				if(rowCount>0) {
//					System.out.println("Record inserted succesfully");
//				}
//				else {
//					System.out.println("No Rows inserted");
//				}
//			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Driver Not Found");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the connection");
			}
		}
		System.out.println("Main End");

	}

}
