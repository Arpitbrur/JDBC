package com.ty.jdbc_crud_with_statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.jdbc_crud_with_statement.dto.Customer;

public class CustomerDao {

	Connection connection = null;
	
	//insert method----------------------------------------------------------------------
	public void insertCustomer(Customer customer) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-with-statement";
			String user="root";
			String pass="Arpit@123";
			
			connection= DriverManager.getConnection(url, user, pass);
			
			Statement statement = connection.createStatement();
			
			String insert = "insert into customer values("+customer.getCustomerId()+",'"+customer.getCustomerName()+"','"+customer.getCustomerEmail()+"')";
		
			statement.execute(insert);
			System.out.println("------------Data inserted successfully------------");
			
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Update method-----------------------------------------------------------------------------
	public void updateCustomer(Customer customer) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-with-statement";
			String user="root";
			String pass="Arpit@123";
			
			connection= DriverManager.getConnection(url, user, pass);
			
			Statement statement = connection.createStatement();
			
			String update = "update customer set customerName = '"+customer.getCustomerName()+"'" + "where customerId = "+customer.getCustomerId()+"";
			
			statement.execute(update);
			System.out.println("Data updated Successfully-----");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Delete method-----------------------------------------------------------------------------------
	public void deleteCustomer(int customerId) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/jdbc-crud-with-statement";
			String user="root";
			String pass="Arpit@123";
			
			connection= DriverManager.getConnection(url, user, pass);
			
			Statement statement = connection.createStatement();
			
			String delete = "delete from customer where customerId ="+ customerId+"";
			
			statement.executeUpdate(delete);
			System.out.println("----------------Data Deleted Successfully------------");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// Display method-------------------------------------------------------------------
	public List<Customer> displayAllCustomer() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/jdbc-crud-with-statement";
			String user="root";
			String pass="Arpit@123";
			
			connection= DriverManager.getConnection(url, user, pass);
			
			Statement statement = connection.createStatement();
			
			String select = "SELECT * FROM customer";
			
			ResultSet resultSet = statement.executeQuery(select);
			
			List<Customer> customers = new ArrayList<Customer>();
			while(resultSet.next() ) {
				Customer customer = new Customer();
				
				customer.setCustomerId(resultSet.getInt("customerId"));
				customer.setCustomerName(resultSet.getString("customerName"));
				customer.setCustomerEmail(resultSet.getString("customerEmail"));
				
				customers.add(customer);
			}
			return customers;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
