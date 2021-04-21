package com.fuad.test.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.test.model.Code;
import com.fuad.test.model.Customer;
import com.fuad.test.repository.CodeRepository;
import com.fuad.test.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	private CodeRepository codeRepository;
	
	public void save(Code code){
		SecureRandom random = new SecureRandom();
    	String codeStr = new BigInteger(130, random).toString(32);
    	code.setCodeStr(codeStr);
		codeRepository.save(code);
	}
	
	public Code findByCodeStr(String codeStr){
		return codeRepository.findByCodeStr(codeStr);
	}
	
	public void delete(Code code){
		codeRepository.delete(code);
	}
	
	public List<Code> findByCodeTypeAndCustomer(int codeType, Customer customer){
		return codeRepository.findByCodeTypeAndCustomer(codeType, customer);
	}
}
