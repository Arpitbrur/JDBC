package com.qsp.jdbc_prepared_statement_eve.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;
import com.qsp.jdbc_prepared_statement_eve.service.MobileService;

public class MobileController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MobileService mobileService = new MobileService();
		Mobile mobile = new Mobile();
		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert\n2. Update\n3. Delete\n4. Add batch\n5. Display\n6. Exit");
			
			int ch = scanner.nextInt();

			switch (ch) {

			case 1: {
					System.out.println("insert the mobileId");
					mobile.setMobileId(scanner.nextInt());
					System.out.println("insert the mobileBrand");
					mobile.setMobileBrand(scanner.next());
					System.out.println("insert the mobilePrice");
					mobile.setMobilePrice(scanner.nextDouble());
					System.out.println("insert the mobileColor");
					mobile.setMobileColor(scanner.next());
					System.out.println("insert the mobileCamera");
					mobile.setMobileCamera(scanner.next());
					
					mobileService.insertMobile(mobile);
			}
				break;
				
			case 2: {
				System.out.println("update the mobileId");
				int id = scanner.nextInt();
				System.out.println("update the mobilecolor");
				String color = scanner.next();
				System.out.println("update the mobilePrice");
				double price= scanner.nextDouble();
				System.out.println("update the mobileCamera");
				String camera = scanner.next();
				
				mobileService.updateMobile(id, color, price, camera);
			   }
			      break;
			      
			case 3:{
				System.out.println(" provide to id to delete");
				int id = scanner.nextInt();
				
				mobileService.deleteMobile(id);
			}  
			  
			  break;
			      
			case 4: {
				System.out.println("how many mobile you want to insert");
				
				int size = scanner.nextInt();
				List<Mobile> mobiles = new ArrayList<Mobile>();
				
				for(int i= 0; i<size;i++) {
					Mobile mobile2 = new Mobile();
					System.out.println("enter tha mobileId");
					mobile2.setMobileId(scanner.nextInt());
					
					System.out.println("enter tha mobileBrand");
					mobile2.setMobileBrand(scanner.next());

					System.out.println("enter tha mobilePrice");
					mobile2.setMobilePrice(scanner.nextDouble());

					System.out.println("enter tha mobileColor");
					mobile2.setMobileColor(scanner.next());

					System.out.println("enter tha mobileCamera");
					mobile2.setMobileCamera(scanner.next());

					mobiles.add(mobile2);
					
				}
				
				mobileService.insertAddBatch(mobiles);
				
			}
			break;
			  
			
			case 5:{
				
				List<Mobile> list = mobileService.displayMobiles();
				
				for(Mobile mobile2 : list) {
					
					System.out.println("MobileId= "+ mobile2.getMobileId());
					System.out.println("Mobileprice"+ mobile2.getMobilePrice());
					System.out.println("MobileBrand"+ mobile2.getMobileBrand());
					System.out.println("MobileColor"+ mobile2.getMobileColor());
					System.out.println("MobileCamera"+ mobile2.getMobileCamera());
					
					System.out.println(".........................................");
					System.out.println("  ");
					
				}
				break;
			}
			case 6:{
				System.exit(0);
			}
          }
		}
	}
}
