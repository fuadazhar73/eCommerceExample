package com.fuad.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Customer;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	Customer findByEmail(String email);

	Customer findByPhoneNumber(String phoneNumber);
	
}
