package com.ty.jdbc_crud_with_statement.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.jdbc_crud_with_statement.dto.Customer;
import com.ty.jdbc_crud_with_statement.service.CustomerService;

public class CustomerController {
		public static void main(String[] args) {
	
			Scanner scanner = new Scanner(System.in);
			CustomerService customerService = new CustomerService();
			Customer customer = new Customer();
			
			while(true) {
				System.out.println("Enter your choice");
				System.out.println("1. Insert\n2. Update\n3. Delete\n4. Display\n5. Exit");
				
				int ch = scanner.nextInt();
				switch(ch) {
				case 1:{
					System.out.println("Enter Customer id");
					customer.setCustomerId(scanner.nextInt());
					System.out.println("Enter Customer NAme");
					customer.setCustomerName(scanner.next());
					System.out.println("Enter Customer Email");
					customer.setCustomerEmail(scanner.next());
					
					customerService.insertCustomer(customer);
			   }break;
			   
				case 2:{
					System.out.println("Enter Customer id");
					customer.setCustomerId(scanner.nextInt());
					System.out.println("Enter Customer NAme");
					customer.setCustomerName(scanner.next());
					
					customerService.updateCustomer(customer);
				}break;
				
				case 3:{
					System.out.println("Enter Customer Id");
					int id = scanner.nextInt();
					
					customerService.deleteCustomer(id);
				}break;
				
				case 4:{
					List<Customer> customers = customerService.displayAllCustomer();
					
					for (Customer customer2 : customers) {
						System.out.println("==========================");
						System.out.println("CustomerId :-"+customer2.getCustomerId());
						System.out.println("CustomerNAme"+customer2.getCustomerName());
						System.out.println("customerEmail:- "+customer2.getCustomerEmail());
						System.out.println("=========================");
					}
					
				}break;
				
				case 5:{
					System.out.println("System closed");
					System.exit(ch);
				}break;
				
				default:{
					System.out.println("Invalid choice");
				
				}
	      }			
      }	
   }
}
