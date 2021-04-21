package com.fuad.test.service;

import java.util.List;

import com.fuad.test.model.Code;
import com.fuad.test.model.Customer;

public interface CodeService {
	
	List<Code> findByCodeTypeAndCustomer(int codeType, Customer customer);
	
	void save(Code code);
	
	Code findByCodeStr(String codeStr);
	
	void delete(Code code);
}

