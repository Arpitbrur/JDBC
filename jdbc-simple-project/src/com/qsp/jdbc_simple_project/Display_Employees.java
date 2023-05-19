package com.qsp.jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display_Employees {
		public static void main(String[] args) {
			Connection conn=null;
			try {
				//Step-1 Load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Step-2 established the connect
	
				String url="jdbc:mysql://localhost:3306/jdbc-simple-project";
				String user="root";
				String pass="Arpit@123";
				
				Connection connection =DriverManager.getConnection(url, user, pass);
				//step-3 create the statement
				
				Statement statement= connection.createStatement();
				//step-4 create the query
				String select ="SELECT * FROM employee";
				
				ResultSet resultSet = statement.executeQuery(select);
			
				while(resultSet.next()) {
					System.out.println("id ="+resultSet.getInt(1));
					System.out.println("name ="+resultSet.getString(2));
					System.out.println("email ="+resultSet.getString(3));
					System.out.println(" ");
				}	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

