package com.fuad.test.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.test.model.Cart;
import com.fuad.test.model.CartItem;
import com.fuad.test.model.Customer;
import com.fuad.test.model.CustomerOrder;
import com.fuad.test.model.CustomerOrderItem;
import com.fuad.test.model.CustomerOrderShippingAddress;
import com.fuad.test.model.ShippingAddress;
import com.fuad.test.repository.CartItemRepository;
import com.fuad.test.repository.CustomerOrderItemRepository;
import com.fuad.test.repository.CustomerOrderRepository;
import com.fuad.test.repository.CustomerOrderShippingAddressRepository;
import com.fuad.test.repository.ShippingAddressRepository;
import com.fuad.test.service.CartService;
import com.fuad.test.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	
	@Autowired
    private CartService cartService;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerOrderShippingAddressRepository customerOrderShippingAddressRepository;
    @Autowired
    private ShippingAddressRepository shippingAddressRepository;
    @Autowired
    private CustomerOrderItemRepository customerOrderItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
	
	public double getCustomerOrderGrandTotalByCart(Cart cart) {
        double grandTotal = 0;
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPriceDouble();
        }

        return grandTotal;
    }
	
	public void addOrderDumpCart(CustomerOrderShippingAddress customerOrderShippingAddress,
									CustomerOrder customerOrder, Cart cart) throws IOException{
		
		if(customerOrderShippingAddress == null || customerOrder == null || cart == null){
			throw new IOException();
		}
		// initiate customerOrderShippingAddress
		ShippingAddress shippingAddress = shippingAddressRepository.findOne(customerOrderShippingAddress.getOriginalShippingAddressId());
		customerOrderShippingAddress.setAddress(shippingAddress.getAddress());
		customerOrderShippingAddress.setCity(shippingAddress.getCity());
		customerOrderShippingAddress.setCountry(shippingAddress.getCountry());
		customerOrderShippingAddress.setFullName(shippingAddress.getFullName());
		customerOrderShippingAddress.setPhoneNumber(shippingAddress.getPhoneNumber());
		customerOrderShippingAddress.setState(shippingAddress.getState());
		customerOrderShippingAddress.setZipCode(shippingAddress.getZipCode());
		
		// initiate customer order
		customerOrder.setCustomer(cart.getCustomer());
		customerOrder.setOrderDate(new Date());
		customerOrder.setOrderTotalPrice(cart.getGrandTotal());
		// for mapping orderItem table
		customerOrderRepository.save(customerOrder);
		cart.setGrandTotal(0);
		cartService.save(cart);
		// dump cartItem to orderItem, empty cart
		for(CartItem cartItem : cart.getCartItems()){
			CustomerOrderItem customerOrderItem = new CustomerOrderItem();
			customerOrderItem.setCustomerOrder(customerOrder);
			customerOrderItem.setProductId(cartItem.getProduct().getProductId());
			customerOrderItem.setProductName(cartItem.getProduct().getProductName());
			customerOrderItem.setProductPrice(cartItem.getProduct().getProductPrice());
			customerOrderItem.setProductQuantity(cartItem.getQuantity());
			customerOrderItemRepository.save(customerOrderItem);
			cartItemRepository.delete(cartItem);
		}
		// for mapping customerOrder table
		customerOrderShippingAddressRepository.save(customerOrderShippingAddress);
		
		customerOrder.setCustomerOrderShippingAddress(customerOrderShippingAddress);
		customerOrderRepository.save(customerOrder);
		
		customerOrderShippingAddress.setCustomerOrder(customerOrder);
		customerOrderShippingAddressRepository.save(customerOrderShippingAddress);
	}
	
	public List<CustomerOrder> getAllCustomerOrderByCustomer(Customer customer){
		return customerOrderRepository.findAllByCustomer(customer);
	}
}
