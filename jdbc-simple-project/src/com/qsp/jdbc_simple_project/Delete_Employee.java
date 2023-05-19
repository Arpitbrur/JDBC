package com.qsp.jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Employee {
	
	public static void main(String[] args) {
		Connection conn=null;
		try {
			//Step-1 Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step-2 established the connect
			
			String url="jdbc:mysql://localhost:3306/jdbc-simple-project";
			String user="root";
			String pass="Arpit@123";
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			//step-3 create the statement
			
			Statement statement= connection.createStatement();
			//step-4 create the query
			
			String delete="delete from employee  where id=1000";
			int id=statement.executeUpdate(delete);
			
			if(id!=0) {
				System.out.println("Data delete");
			}else {
				System.out.println("Hey please check your id that is not present");
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
