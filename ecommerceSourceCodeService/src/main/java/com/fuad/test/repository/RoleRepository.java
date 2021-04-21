package com.fuad.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Customer;
import com.fuad.test.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByAuthorityAndCustomer(String auth, Customer customer);
}
