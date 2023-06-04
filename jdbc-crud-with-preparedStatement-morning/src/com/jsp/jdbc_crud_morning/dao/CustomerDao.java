package com.jsp.jdbc_crud_morning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.jdbc_crud_morning.connection.CustomerConnection;
import com.jsp.jdbc_crud_morning.dto.Customer;

public class CustomerDao {

	Connection connection = null;
	// Insert Customer------------------------------------------------------------------
	public void insertCustomer(Customer customer) {
		
		connection = CustomerConnection.getConnecion();
		
		String insert = "insert into customer values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerLocation());
			
			preparedStatement.execute();
			
			System.out.println("Data Inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// update customer----------------------------------------------------------------------
	public void updateCustomer(int customerId,String customerName,String customerEmail,String customerLocation) {
		
		connection= CustomerConnection.getConnecion();
		
		String update = "update customer set customerName=?,customerEmail=?,customerLocation=? where customerId=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			
			preparedStatement.setInt(4, customerId);
			preparedStatement.setString(1, customerName);
			preparedStatement.setString(2, customerEmail);
			preparedStatement.setString(3, customerLocation);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Data Updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
