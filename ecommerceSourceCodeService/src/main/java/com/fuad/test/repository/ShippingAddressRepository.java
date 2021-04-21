package com.fuad.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Customer;
import com.fuad.test.model.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long>{
	
	List<ShippingAddress> findAllByCustomer(Customer customer);
	
	
}
