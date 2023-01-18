package com.citibank.main;

import java.util.List;

import com.citibank.main.domain.Customer;
import com.citibank.main.service.CustomerService;

public class CustomerMain {

	public static void main(String[] args) {
		
		CustomerService customerService = new CustomerService();
		
//		System.out.println("\nRetrieve All Added Customers From Database");
//
//		List<Customer> customerList = customerService.getAllCustomers();
//
//		for (Customer customer : customerList) {
//			System.out.println(customer);
//		}
//		
//		System.out.println("\nRetrieve Customer Using Customer ID");
//		
//		Customer customer = customerService.getCustomerByCustomerId(5);
//		
//		if(customer!=null) {
//			System.out.println(customer);
//		}else
//		System.out.println("\nInvalid Customer ID");
		
//		System.out.println("Adding New Customers");
//		Customer cust1 = new Customer(1, "Pune", "Ram");
//		Customer cust2 = new Customer(2, "Indore", "Shyam");
//		Customer cust3 = new Customer(3, "Panvel", "Kishan");
//		Customer cust4 = new Customer(4, "Tambaram", "Bharat");
//		Customer cust5 = new Customer(5, "Gurgaon", "Siddharth");
//
//		System.out.println("Adding 1st Customer::" + customerService.addNewCustomer(cust1));
//		System.out.println("Adding 2nd Customer::" + customerService.addNewCustomer(cust2));
//		System.out.println("Adding 3rd Customer::" + customerService.addNewCustomer(cust3));
//		System.out.println("Adding 4th Customer::" + customerService.addNewCustomer(cust4));
//		System.out.println("Adding 5th Customer::" + customerService.addNewCustomer(cust5));
		
//		System.out.println("\nUpdate Customer");
//		
//		Customer custNew = new Customer(3, "Vivek", "Mumbai");
//
//		if (customerService.updateCustomerByCustomerId(custNew)) {
//			System.out.println("Customer Successfully Updated");
//			System.out.println(
//					"New Customer Details::" + customerService.getCustomerByCustomerId(custNew.getCustomerId()));
//		} else {
//			System.out.println("Invalid Customer ID");
//		}
			
		System.out.println("\nDelete Customer");

		if (customerService.deleteCustomerByCustomerId(1)) {
			System.out.println("Customer Deleted Successfully");
		} else
			System.out.println("Invalid Customer ID");
		
	}

}
