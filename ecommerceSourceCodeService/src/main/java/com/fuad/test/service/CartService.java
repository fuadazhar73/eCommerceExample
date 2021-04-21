package com.fuad.test.service;

import java.io.IOException;

import com.fuad.test.model.Cart;

public interface CartService {
	
	Cart validate(Object customerId) throws IOException;
	
	void emptyCart(Cart cart);
	
	void save(Cart cart);
}