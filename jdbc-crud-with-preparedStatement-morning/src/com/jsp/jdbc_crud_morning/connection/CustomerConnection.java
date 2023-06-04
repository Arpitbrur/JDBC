package com.jsp.jdbc_crud_morning.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerConnection {

	public static Connection getConnecion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-with-preparedStatement-morning";
			String user = "root";
			String pass = "Arpit@123";
			
			Connection connection = DriverManager.getConnection(url,user,pass);
			
			if(connection!=null) {
		    	return connection;
		    }else {
		    	System.out.println("check your url or user or pass");
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
