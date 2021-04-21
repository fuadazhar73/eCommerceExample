package com.fuad.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.fuad.test.model.CustomerOrderShippingAddress;

public interface CustomerOrderShippingAddressRepository 
extends CrudRepository <CustomerOrderShippingAddress, Long> {

}
