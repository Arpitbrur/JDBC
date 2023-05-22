package com.ibm.jdbc_crud_operation_statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.jdbc_crud_operation_statement.dto.laptop;

public class laptopDao {

	// insert laptop
	public void insertLaptop(laptop laptop) {
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-operation-statement";
			String user= "root";
			String pass= "Arpit@123";
			
			Connection connection = DriverManager.getConnection(url,user,pass);
			 
			 Statement statement = connection.createStatement();
			 
			 String insert = "insert into laptop values("+laptop.getId()+",'"+laptop.getName()+"',"
			 		+ ""+laptop.getPrice()+",'"+laptop.getColor()+"')";

			 statement.execute(insert);
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	// update LaptopMethods
	public void updatelaptop(laptop laptop) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-operation-statement";
			String user= "root";
			String pass= "Arpit@123";
			
		    Connection connection = DriverManager.getConnection(url, user, pass);
			
		    Statement statement = connection.createStatement();
		    
		    String update= "update laptop set name='"+laptop.getName()+"'"+ "where id = "+laptop.getId()+"";
		    
		    int id = statement.executeUpdate(update);
		    
		    if(id!=0) {
		    	System.out.println("data update");
		    }else {
		    	System.out.println("id is not present");
		    }
		    		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//deletelaptop
	
	public void deletelaptop(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-operation-statement";
			String user= "root";
			String pass= "Arpit@123";
			
		    Connection connection = DriverManager.getConnection(url, user, pass);
			
		    Statement statement = connection.createStatement();
		    
		    String delete= "delete from laptop where id ="+id+"";
		    
		    int id1 = statement.executeUpdate(delete);
		    
		    if(id!=0) {
		    	System.out.println("data delete");
		    }else {
		    	System.out.println("id is not present");
		    }
		    		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// display laptop
	
	public List<laptop> displaylaptop() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-operation-statement";
			String user= "root";
			String pass= "Arpit@123";
			Connection connection = DriverManager.getConnection(url, user, pass);
			
		    Statement statement = connection.createStatement();
		    
		    String select= "SELECT * FROM laptop";
		    
		   ResultSet resultSet=statement.executeQuery(select);
		   
		   List<laptop> laptops = new ArrayList<laptop>();
		    
			while(resultSet.next()) {
				
				laptop laptop = new laptop();
				laptop.setId(resultSet.getInt("id"));
				laptop.setName(resultSet.getString("name"));
				laptop.setPrice(resultSet.getDouble("price"));
				laptop.setColor(resultSet.getString("color"));
				
				laptops.add(laptop);
				
			}
			return laptops;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
