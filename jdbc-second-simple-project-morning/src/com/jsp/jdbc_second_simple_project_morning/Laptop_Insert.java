package com.jsp.jdbc_second_simple_project_morning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Laptop_Insert {

	public static void main(String[] args) {
		
		Connection connection= null;
		
		try {
			// Step- 1 Load the Driver------------------------------------------------
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step-2 Establish the Connect--------------------------------------------
			
			String url = "jdbc:mysql://localhost:3306/jdbc_first_simple_project_morning";
			String user = "root";
			String pass = "Arpit@123";
			
			connection = DriverManager.getConnection(url, user,pass);
			
			// Step-3 Create Statement--------------------------------------------------
			
			Statement statement = connection.createStatement();
			
			// Step-4 Create Query-------------------------------------------------------
			
		//	String insert = "insert into Laptop values(101, 'hp', 35000.0)";
			String insert1 = "insert into Laptop values(102, 'samsung', 55000.0)";
			
		//	statement.execute(insert);
			statement.execute(insert1);
			System.out.println("-------------Laptop Insert Successfully--------------");
			System.out.println(connection);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// Step-5 Close the Connection------------------------------------------------

		finally {			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
