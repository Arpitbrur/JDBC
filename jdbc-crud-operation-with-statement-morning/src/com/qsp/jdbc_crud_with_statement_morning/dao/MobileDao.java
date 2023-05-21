package com.qsp.jdbc_crud_with_statement_morning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
