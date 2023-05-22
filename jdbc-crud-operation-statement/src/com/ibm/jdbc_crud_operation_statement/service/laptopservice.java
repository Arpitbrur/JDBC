package com.ibm.jdbc_crud_operation_statement.service;

import java.util.List;

import com.ibm.jdbc_crud_operation_statement.dao.laptopDao;
import com.ibm.jdbc_crud_operation_statement.dto.laptop;

public class laptopservice {

	
	laptopDao dao = new laptopDao();
	
	public void insertlaptop(laptop laptop) {
		if(laptop.getPrice()<=40000) {
			dao.insertLaptop(laptop);
			System.out.println("this is service class");
		}else {
			System.out.println("price is too high");
		}
	}
	
	// update LaptopMethods
		public void updatelaptop(laptop laptop) {
			dao.updatelaptop(laptop);
		}
		

		//delete laptop
		
		public void deletelaptop(int id) {
			// TODO Auto-generated method stub
			dao.deletelaptop(id);
			
		}
		
		//display laptop
		
		public List<laptop> displaylaptop(){
			List<laptop> laptops = dao.displaylaptop();
			return laptops;
		}
		
}
