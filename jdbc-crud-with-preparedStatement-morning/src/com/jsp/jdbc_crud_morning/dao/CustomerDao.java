package com.jsp.jdbc_crud_morning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// delete method-----------------------------------------------------------------------------
	public void deleteCustomer(int customerId) {
		
		connection = CustomerConnection.getConnecion();
		
		String delete = "delete from customer where customerid=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			
			preparedStatement.setInt(1, customerId);
			
			preparedStatement.executeUpdate();
			System.out.println("Data deleted Successfully..............");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Add All Batch-------------------------------------------------------------------------------
	public void insertAllBatch(List<Customer> customer) {
		
		connection = CustomerConnection.getConnecion();	
		String insert = "insert into customer values(?,?,?,?) ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			
			for (Customer customer2 : customer) {
				preparedStatement.setInt(1, customer2.getCustomerId());
				preparedStatement.setString(2, customer2.getCustomerName());
				preparedStatement.setString(3, customer2.getCustomerEmail());
				preparedStatement.setString(4, customer2.getCustomerLocation());
				
				preparedStatement.addBatch();
			}			
			preparedStatement.executeBatch();
			
			System.out.println("Multiple data stored Succcessfully.......");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	// display customer-------------------------------------------------------------------------
	public List<Customer> displayAllCustomer() {
		
		connection = CustomerConnection.getConnecion();
		
		String select = "SELECT * from customer";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			List<Customer> list = new ArrayList<Customer>();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customerId"));
				customer.setCustomerName(resultSet.getString("customerName"));
				customer.setCustomerEmail(resultSet.getString("customerEmail"));
				customer.setCustomerLocation(resultSet.getString("customerLocation"));
				
				list.add(customer);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
