package com.jsp.jdbc_second_simple_project_morning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Laptop_Display {

	public static void main(String[] args) {
		
		Connection connection = null;

		try {
			// Step-1 load the driver---------------------------------------------------

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step-2 Establish Connection------------------------------------------------

			String url = "jdbc:mysql://localhost:3306/jdbc_first_simple_project_morning";
			String user = "root";
			String password = "Arpit@123";
			
			connection = DriverManager.getConnection(url, user, password);
			
			// Create Statement-----------------------------------------------------------
			
			Statement statement = connection.createStatement();
			
			// Create Query---------------------------------------------------------------
			
			String select = "SELECT * FROM Laptop";
			
			ResultSet resultSet= statement.executeQuery(select);
			
			while(resultSet.next()) {
				System.out.println("laptopId:- " + resultSet.getInt(1));
				System.out.println("laptopName:- "+resultSet.getString(2));
				System.out.println("laptopPrice:- "+resultSet.getDouble(3));
				System.out.println(" ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// Step-5 Close Connection---------------------------------------------------------
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
