package com.ibm.jdbc_crud_operation_statement.controller;

import java.util.List;
import java.util.Scanner;

import com.ibm.jdbc_crud_operation_statement.dto.laptop;
import com.ibm.jdbc_crud_operation_statement.service.laptopservice;


public class laptopController {

	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		laptop laptop = new laptop();
		laptopservice laptopservice = new laptopservice();
		while(true) {
			System.out.println("1.InsertLaptop\n2.UpdateLaptop\n3.DeleteLaptop\n4.DisplayLaptop");
			System.out.println("Choose your choice");
			
			int ch = scanner.nextInt();
			
			switch(ch) {
			
			case 1:{
				System.out.println("Enter the LaptopId");
				laptop.setId(scanner.nextInt());
				System.out.println("Enter the LaptopName");
				laptop.setName(scanner.next());
				System.out.println("Enter the LaptopPrice");
				laptop.setPrice(scanner.nextDouble());
				System.out.println("Enter the LaptopColor");
				laptop.setColor(scanner.next());
				
				laptopservice.insertlaptop(laptop);
			
			}break;
			
			case 2:{
				System.out.println("Enter the LaptopId");
				laptop.setId(scanner.nextInt());
				System.out.println("Enter the LaptopName");
				laptop.setName(scanner.next());
				System.out.println("Enter the LaptopColor");
				laptop.setColor(scanner.next());
								
				laptopservice.updatelaptop(laptop);
			}break;
			
			case 3:{
				System.out.println("Enter the laptopId");
				int id = scanner.nextInt();
				
				laptopservice.deletelaptop(id);
				
			}break;
			
			case 4:{
				List<laptop> laptops = laptopservice.displaylaptop();
				
				for(laptop laptop2 : laptops) {
				System.out.println("");
				System.out.println("Id = "+laptop2.getId());
				System.out.println("Name = "+laptop2.getName());
				System.out.println("Price = "+laptop2.getPrice());
				System.out.println("Color = "+laptop2.getColor());
				}
	
				break;
			}
		}
		
		}
	}
}
