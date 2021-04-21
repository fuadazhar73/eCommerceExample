package com.fuad.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Customer;
import com.fuad.test.model.CustomerOrder;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long>{

	List<CustomerOrder> findAllByCustomer(Customer customer);
}