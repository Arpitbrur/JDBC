package com.jsp.jdbc_second_simple_project_morning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Laptop_Update {

	public static void main(String[] args) {
		
		Connection connection = null;
		
		try {
			// Step-1 load the driver---------------------------------------------------
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step-2 Establish Connection------------------------------------------------
			
			String url = "jdbc:mysql://localhost:3306/jdbc_first_simple_project_morning";
			String user = "root";
			String password ="Arpit@123";
			
			connection = DriverManager.getConnection(url, user, password);
			
			// Step-3 Create Statement--------------------------------------------------
			
			Statement statement = connection.createStatement();
			
			// Step-4 Create Query-------------------------------------------------------
			String update = "update laptop set laptopName='dell' where laptopId=102";
			
			statement.execute(update);
			System.out.println("--------------Data updated-----------------");
			System.out.println(connection); 
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		// Step-5 Close the Connection------------------------------------------------

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
