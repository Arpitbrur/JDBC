package com.qsp.jdbc_prepared_statement_football.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.qsp.jdbc_prepared_statement_football.dto.Football;
import com.qsp.jdbc_prepared_statement_football.service.FootballService;

public class FootballController {

	
	public static void main(String[] args) {
		
		Scanner scanner =  new Scanner(System.in);
		FootballService footballService = new FootballService();
		Football football = new Football();
		while(true) {
			System.out.println("============1.Insert your data===============");
			System.out.println("============2.Update your data===============");
			System.out.println("============3.Delete your data===============");
			System.out.println("============4.Display your data==============");
			System.out.println("============5.Addbatch your data==============");
			
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:{
				System.out.println("insert the FootballId");
				football.setId(scanner.nextInt());
				System.out.println("insert the FootballColor");
				football.setColor(scanner.next());
				System.out.println("insert the FootballPrice");
				football.setPrice(scanner.nextDouble());
				System.out.println("insert the Footballbrand");
				football.setBrand(scanner.next());
				
				footballService.insertFootball(football);
			}
			break;
			
			case 2: {
				System.out.println("update the FootballId");
				int id = scanner.nextInt();
				System.out.println("update the Footballcolor");
				String color = scanner.next();
				System.out.println("update the FootballPrice");
				double price= scanner.nextDouble();
				System.out.println("update the Footballbrand");
				String brand = scanner.next();
				
				footballService.updateFootball(id, color, price, brand);
			   }
			      break;
			      
			case 3: {
				System.out.println(" please provide id to delete");
				int id = scanner.nextInt();
				
				footballService.deleteFootball(id);
				
			}
				break;
				
			case 4:{
				
				List<Football> list = footballService.displayFootballs();
				for(Football football2 : list) {
					
					System.out.println("FootballId= "+ football2.getId());
					System.out.println("Footballprice"+ football2.getPrice());
					System.out.println("FootballBrand"+ football2.getBrand());
					System.out.println("FootballColor"+ football2.getColor());
				
					System.out.println(".........................................");
					System.out.println("  ");	
				}
			}	
			break;
			
			   case 5:{
				   System.out.println("how many football you want to insert");
					
					int size = scanner.nextInt();
					List<Football> football1 = new ArrayList<Football>();
					
					for(int i= 0; i<size;i++) {
						Football football2 = new Football();
						System.out.println("enter tha footballId");
						football2.setId(scanner.nextInt());
						
						System.out.println("enter tha footballColor");
						football2.setColor(scanner.next());

						
						System.out.println("enter tha footballBrand");
						football2.setBrand(scanner.next());

						System.out.println("enter tha footballPrice");
						football2.setPrice(scanner.nextDouble());

						
		

						football1.add(football2);
						
					}
					
					footballService.insertAddBatch(football1);

			}
				
	        }
		}
    }
}