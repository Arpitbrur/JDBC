package com.qsp.jdbc_prepared_statement_football.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.jdbc_prepared_statement_football.connection.FootballConnection;
import com.qsp.jdbc_prepared_statement_football.dto.Football;

public class FootballDao {

	Connection connection = null;
	
	public void insertFootball(Football football) {
		
		connection = FootballConnection.getConnection();
		
		String insert = "insert into football values(?,?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(insert);
		
			preparedStatement.setInt(1, football.getId());
			preparedStatement.setString(2, football.getColor());
			preparedStatement.setString(3, football.getBrand());
			preparedStatement.setDouble(4, football.getPrice());
			
			preparedStatement.execute();
			
			System.out.println("----------Data inserted---------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//update method
	
	public void updateFootball(int id, String color, double price, String brand) {
		
        connection= FootballConnection.getConnection();
		
		String update= "update football set color=?,price=?,brand=? where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			
			preparedStatement.setInt(4, id);
			preparedStatement.setString(1, color);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, brand);
			
			preparedStatement.executeUpdate();
			
			System.out.println("----------Data update----------");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// delete method
	
	public void deleteFootball(int id) {
		
		connection = FootballConnection.getConnection();
		
		String delete = "delete from football where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			
            preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("-----------Data deleted-----------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// display method
	

	public List<Football> displayFootballs() {
		connection = FootballConnection.getConnection();
		String select = "Select * from football";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			List<Football> list= new ArrayList<Football>();
			
			while(resultSet.next()) {
				
				Football football = new Football();
				
				football.setId(resultSet.getInt("id"));
				football.setColor(resultSet.getString("color"));
				football.setPrice(resultSet.getDouble("price"));
				football.setBrand(resultSet.getString("brand"));
				
				list.add(football);	
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Add batch method
	public void insertAddBatch(List<Football>football) {
		connection = FootballConnection.getConnection();
		
		String insert = "insert into football values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			for (Football football2 : football) {
				preparedStatement.setInt(1, football2.getId());
				preparedStatement.setString(4, football2.getColor());
				preparedStatement.setString(2, football2.getBrand());
				preparedStatement.setDouble(3, football2.getPrice());
				
				
	
				preparedStatement.addBatch();
				
			}
			preparedStatement.executeBatch();
		
			System.out.println("------------Data Stored------------");
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
