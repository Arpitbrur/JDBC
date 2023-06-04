package com.jsp.jdbc_crud_morning.controller;

import java.util.Scanner;

import com.jsp.jdbc_crud_morning.dto.Customer;
import com.jsp.jdbc_crud_morning.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		CustomerService customerService = new CustomerService();
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert\n2. Update");
			int ch = scanner.nextInt();
			
			switch(ch) {
			case 1:{
				System.out.println("Enter CustomerId");
				customer.setCustomerId(scanner.nextInt());
				System.out.println("Enter customerName");
				customer.setCustomerName(scanner.next());
				System.out.println("Enter customerEmail");
				customer.setCustomerEmail(scanner.next());
				System.out.println("Enter customerLocation");
				customer.setCustomerLocation(scanner.next());
				
				customerService.insertCustomer(customer);
			}break;
			
			case 2:{
				System.out.println("Enter CustomerId");
				int customerId = scanner.nextInt();
				System.out.println("Enter customerName");
				String customerName = scanner.next();
				System.out.println("Enter customerEmail");
				String customerEmail = scanner.next();
				System.out.println("Enter customerLocation");
				String customerLocation = scanner.next();
				
				customerService.updateCustomer(customerId, customerName, customerEmail, customerLocation);
			}break;
			
			
			}
		}
	}
}
