package com.fuad.test.service;

import java.util.List;

import com.fuad.test.model.ShippingAddress;

public interface CustomerAddressService {
	
	List<ShippingAddress> getAllShippingAddressByCustomerId(Object customerId);
	
	void addShippingAddressObject(Object customerId, ShippingAddress shippingAddress);
}