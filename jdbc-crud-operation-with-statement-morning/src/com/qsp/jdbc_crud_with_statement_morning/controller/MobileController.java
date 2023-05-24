package com.qsp.jdbc_crud_with_statement_morning.controller;

import java.util.List;
import java.util.Scanner;

import com.qsp.jdbc_crud_with_statement_morning.dto.Mobile;
import com.qsp.jdbc_crud_with_statement_morning.service.MobileService;

public class MobileController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		MobileService mobileService = new MobileService();
		Mobile mobile = new Mobile();
		
		while(true) {
			System.out.println("Enter your Choice");
			System.out.println("1. Insert\n2. Update\n3. Delete\n4. Display\n5. Exit");
			
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:{
				System.out.println("Enter mobileId");
				mobile.setMobileId(scanner.nextInt());
				System.out.println("Enter mobileName");
				mobile.setMobileName(scanner.next());
				System.out.println("Enter mobileColor");
				mobile.setMobileColor(scanner.next());
				System.out.println("Enter mobilePrice ");
				mobile.setMobilePrice(scanner.nextDouble());
				
				mobileService.insertMobile(mobile);
			}break;
			
			case 2:{
				System.out.println("Enter mobileId");
				mobile.setMobileId(scanner.nextInt());
				System.out.println("Enter mobileName");
				mobile.setMobileName(scanner.next());
				System.out.println("Enter mobileColor");
				mobile.setMobileColor(scanner.next());
				System.out.println("Enter mobilePrice ");
				mobile.setMobilePrice(scanner.nextDouble());
				
				mobileService.updateMobile(mobile);
			}break;
			
			case 3:{
				System.out.println("Enter mobileID");
				int id = scanner.nextInt();
				mobileService.deleteMobile(id);
			}break;
			
			case 4:{
				List<Mobile> mobiles = mobileService.displayMobile();
				
				for (Mobile mobile2 : mobiles) {
					System.out.println(" ");
					System.out.println("mobileId:- "+mobile2.getMobileId());
					System.out.println("MobileName:-"+mobile2.getMobileName());
					System.out.println("MobieColor:- "+mobile2.getMobileColor());
					System.out.println("MobilePrice:- "+mobile2.getMobilePrice());
					System.out.println(" ");
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
