package com.qsp.jdbc_simple_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Employee {
public static void main(String[] args) { 
	
	Connection conn=null;
	try {
		//Step-1 Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step-2 established the connect
		String url="jdbc:mysql://localhost:3306/jdbc-simple-project";
		String user="root";
		String pass="Arpit@123";
		
		 conn = DriverManager.getConnection(url, user, pass);
		
		//step-3 create the statement
		
		Statement statement= conn.createStatement();
		
		//step-4 create the query
		String insert = "insert into employee values(1002, 'Arpit', 'Arpit123@gmail.com')";
		
		statement.execute(insert);
		System.out.println("inserted.........");
		
		System.out.println(conn);
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		//step-5 close the connection
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
