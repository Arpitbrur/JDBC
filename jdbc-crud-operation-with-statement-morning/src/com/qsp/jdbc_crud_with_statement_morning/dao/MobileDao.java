package com.qsp.jdbc_crud_with_statement_morning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qsp.jdbc_crud_with_statement_morning.dto.Mobile;

public class MobileDao {

	Connection connection = null;
	
	// insert mobile----------------------------------------------------------------------------------
	public void insertMobile(Mobile mobile) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-with-statement-morning";
			String user = "root";
			String password = "Arpit@123";
			
			connection = DriverManager.getConnection(url,user, password);
					
			Statement statement = connection.createStatement();
			
			String insert ="insert into Mobile values("+mobile.getMobileId()+", '"+mobile.getMobileName()+"','"+mobile.getMobileColor()+"', "+mobile.getMobilePrice()+")";
			
			System.out.println("-----Data Inserted Successfully-----------------");
			statement.execute(insert);
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// update mobile------------------------------------------------------------------------------------
	public void  updateMobile(Mobile mobile) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-with-statement-morning";
			String user = "root";
			String password = "Arpit@123";
			
			connection= DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();
			
			String update = "update mobile set mobileName = '"+mobile.getMobileName()+"'" + "where mobileId = "+ mobile.getMobileId()+"";
			statement.execute(update);
			System.out.println("--------------Data updated Successfully-----------------");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// delete mobile------------------------------------------------------------------------------------
	public void deleteMobile(int mobileId) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-with-statement-morning";
			String user = "root";
			String password = "Arpit@123";
			
			connection= DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();

		    String delete= "delete from mobile where mobileId ="+mobileId+"";

		    int id =statement.executeUpdate(delete);
		    if(id != 0) {
		    	System.out.println("Data deleted Successfully");
		    }else {
		    	System.out.println("Given id is not found in database");
		    }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// display mobile----------------------------------------------------------------------------------
	public List<Mobile> displayMobile(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-with-statement-morning";
			String user = "root";
			String password = "Arpit@123";
			
			connection= DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();
			
			String select = "SELECT * FROM mobile";
			
			ResultSet resultSet = statement.executeQuery(select);
			
			List<Mobile> mobiles = new ArrayList<Mobile>();
			while(resultSet.next()) {
				Mobile mobile = new Mobile();
				mobile.setMobileId(resultSet.getInt("mobileId"));
				mobile.setMobileName(resultSet.getString("mobileName"));
				mobile.setMobileColor(resultSet.getString("mobileColor"));
				mobile.setMobilePrice(resultSet.getDouble("mobilePrice"));
				
				mobiles.add(mobile);
			}
			return mobiles;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}
}
