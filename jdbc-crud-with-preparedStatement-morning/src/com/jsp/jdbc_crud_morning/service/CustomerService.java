package com.jsp.jdbc_crud_morning.service;

import java.util.List;

import com.jsp.jdbc_crud_morning.dao.CustomerDao;
import com.jsp.jdbc_crud_morning.dto.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();
	
	// Insert Customer------------------------------------------------------------------
	public void insertCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
	}	
	
	// update customer----------------------------------------------------------------------
	public void updateCustomer(int customerId,String customerName,String customerEmail,String customerLocation) {
		customerDao.updateCustomer(customerId, customerName, customerEmail, customerLocation);
	}	
	
	// delete method-----------------------------------------------------------------------------
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}	
	
	// Add All Batch-------------------------------------------------------------------------------
	public void insertAllBatch(List<Customer> customer) {
		customerDao.insertAllBatch(customer);
	}
	
	// display customer-------------------------------------------------------------------------
	public List<Customer> displayAllCustomer() {
		return customerDao.displayAllCustomer();
	}	
}
