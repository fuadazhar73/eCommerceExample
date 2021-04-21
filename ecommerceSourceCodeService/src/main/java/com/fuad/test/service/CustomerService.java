package com.fuad.test.service;

import java.util.List;

import com.fuad.test.model.Customer;

public interface CustomerService {
	
	Customer findOne(Long customerId);
	
	void save(Customer customer);
	
	void activeAccount(String codeStr);
	
	Customer findByEmail(String email);
	Customer findByPhoneNumber(String phoneNumber);
	
	boolean hasRole(String role, Customer customer);
	
	List<Customer> getAllCustomer();
	
	void delete(Long customerId);
}
