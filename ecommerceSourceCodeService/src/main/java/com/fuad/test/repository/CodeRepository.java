package com.fuad.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.Code;
import com.fuad.test.model.Customer;

public interface CodeRepository extends CrudRepository<Code, Long>{
	
	List<Code> findByCodeTypeAndCustomer(int codeType, Customer customer);
	
	Code findByCodeStr(String codeStr);
}
