package com.fuad.test.service;

import com.fuad.test.model.Customer;

public interface EmailSenderService {

	void sendActiveCode(Customer customer);
	
	void sendResetPasswordCode(Customer customer);
}
