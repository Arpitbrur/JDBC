package com.qsp.jdbc_prepared_statement_football.service;

import java.util.List;


import com.qsp.jdbc_prepared_statement_football.dao.FootballDao;
import com.qsp.jdbc_prepared_statement_football.dto.Football;

public class FootballService {

	FootballDao dao = new FootballDao();
	
	// insert method
	public void insertFootball(Football football) {
		dao.insertFootball(football);
	}
	
	// update football method
	
			public void updateFootball(int id, String color,  double price, String brand) {
				dao.updateFootball(id, color, price, brand);
			}
		
	// delete metFootball
			public void deleteFootball(int id) {
				dao.deleteFootball(id);
			}
       //display method mobile
			
			public List<Football> displayFootballs(){
				
				List<Football> list = dao.displayFootballs();
				return list;
			}
			
			// Insert AddBatch method
			public void insertAddBatch(List<Football> football) {
				dao.insertAddBatch(football);
			}
			
}
