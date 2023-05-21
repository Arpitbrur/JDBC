package com.qsp.jdbc_crud_with_statement_morning.controller;

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
			System.out.println("1.Insert");
			
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
			
			}
		}
	}
}
