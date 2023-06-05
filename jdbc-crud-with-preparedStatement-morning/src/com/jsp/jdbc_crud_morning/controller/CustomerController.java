package com.jsp.jdbc_crud_morning.controller;

import java.util.ArrayList;
import java.util.List;
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
			System.out.println("1. Insert\n2. Update\n3. Delete\n4. AddAllBAtch\n5. Display\n6. Exit");
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
			
			case 3:{
				System.out.println("Enter the customerId");
				int id = scanner.nextInt();
				
				customerService.deleteCustomer(id);
			}break;
			
			case 4:{
				System.out.println("how many customer you want to insert");
				
				int size = scanner.nextInt();
				List<Customer> customers = new ArrayList<Customer>();
				
				for (int i = 0; i < size; i++) {
					Customer customer2 = new Customer();
					System.out.println("Enter CustomerId");
					customer2.setCustomerId(scanner.nextInt());
					System.out.println("Enter customerName");
					customer2.setCustomerName(scanner.next());
					System.out.println("Enter customerEmail");
					customer2.setCustomerEmail(scanner.next());
					System.out.println("Enter customerLocation");
					customer2.setCustomerLocation(scanner.next());
					
					customers.add(customer2);
					
				}
				customerService.insertAllBatch(customers);

			}break;
			
			case 5:{
				List<Customer> list = customerService.displayAllCustomer();
				
				for (Customer customer2 : list) {
					System.out.println("customerId:-" +customer2.getCustomerId());
					System.out.println("CustomerName:- "+customer2.getCustomerName());
					System.out.println("CustmomerEmail:- "+customer2.getCustomerEmail());
					System.out.println("CustomerLOcation:- "+customer.getCustomerLocation());
					
					System.out.println("================================");
					
				}
			}break;
			
			case 6:{
				System.exit(0);
			}
			
			}
		}
	}
}
