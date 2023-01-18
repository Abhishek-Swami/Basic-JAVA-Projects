package com.citibank.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citibank.main.domain.Customer;
import com.citibank.main.factory.ConnectionFactory;

public class CustomerRepository implements CustomerRepositoryInteface {

	private List<Customer> customersList = new ArrayList<>();
	
	private String sql;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private int rowCount;
	private ResultSet resultSet;
	

	@Override
	public boolean addNewCustomer(Customer customer) {
		connection = new ConnectionFactory().getConnection();
		sql="insert into customer_detail(name, address) values(?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			rowCount = preparedStatement.executeUpdate();
			if(rowCount>0) {
				System.out.println("Record inserted succesfully");
				return true;
  			}
		} catch (SQLException e) {
			System.out.println("Failed while preapring the query");
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the connection");
			}
		}
	return false;
	}

	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		connection = new ConnectionFactory().getConnection();
		sql="select * from customer_detail where customer_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Data Success from Database");
			if (resultSet.next()) {
				int customerID = resultSet.getInt("customer_id");
				String name=resultSet.getString("name");
				String address = resultSet.getString("address");
				Customer cust = new Customer(customerID,name,address);
				return cust;
			}
	
		} catch (SQLException e) {
			System.out.println("Failed while preapring the query");
			System.out.println(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the connection");
			}
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		connection = new ConnectionFactory().getConnection();
		sql="select * from customer_detail";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("Data Success from Database");
			while(resultSet.next()) {
				int customerID = resultSet.getInt("customer_id");
				String name=resultSet.getString("name");
				String address = resultSet.getString("address");
				Customer cust = new Customer(customerID,name,address);
				customersList.add(cust);
			}
	
		} catch (SQLException e) {
			System.out.println("Failed while preapring the query");
			System.out.println(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the connection");
			}
		}
		return customersList;
	}

	@Override
	public boolean updateCustomerByCustomerId(Customer customer) {
		connection = new ConnectionFactory().getConnection();
		sql="update customer_detail set name=?,address=? where customer_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress());
			preparedStatement.setInt(3, customer.getCustomerId());
			rowCount = preparedStatement.executeUpdate();
			if(rowCount>0) {
				System.out.println("Record updated succesfully");
				return true;
  			}
		} catch (SQLException e) {
			System.out.println("Failed while preapring the query");
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the connection");
			}
		}
		return false;
	}

	@Override
	public boolean deleteCustomerByCustomerId(int customerId) {
		connection = new ConnectionFactory().getConnection();
		sql="delete from customer_detail where customer_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			rowCount = preparedStatement.executeUpdate();
			if(rowCount>0) {
				System.out.println("Record Deleted.");
				return true;
			}else {
				System.out.println("Delete Operation Failed");
			}
		}catch(SQLException e) {
			System.out.println("Failed while preparing the query");
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}

}
