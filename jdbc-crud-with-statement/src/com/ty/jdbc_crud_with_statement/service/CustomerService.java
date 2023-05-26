package com.ty.jdbc_crud_with_statement.service;

import java.util.List;

import com.ty.jdbc_crud_with_statement.dao.CustomerDao;
import com.ty.jdbc_crud_with_statement.dto.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();
	
	//insert method----------------------------------------------------------------------
	public void insertCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
	}
	
	// Update method-----------------------------------------------------------------------------
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}
	
	// Delete method-----------------------------------------------------------------------------------
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}	
	
	// Display method-------------------------------------------------------------------
	public List<Customer> displayAllCustomer() {
		return customerDao.displayAllCustomer();
	}	
}
