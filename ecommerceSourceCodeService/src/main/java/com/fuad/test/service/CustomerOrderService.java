package com.fuad.test.service;

import java.io.IOException;
import java.util.List;

import com.fuad.test.model.Cart;
import com.fuad.test.model.Customer;
import com.fuad.test.model.CustomerOrder;
import com.fuad.test.model.CustomerOrderShippingAddress;

public interface CustomerOrderService {
	
	double getCustomerOrderGrandTotalByCart(Cart cart);
	
	void addOrderDumpCart(CustomerOrderShippingAddress customerOrderShippingAddress, CustomerOrder customerOrder, Cart cart) throws IOException;
	
	List<CustomerOrder> getAllCustomerOrderByCustomer(Customer customer);
}