package com.fuad.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuad.test.model.Customer;
import com.fuad.test.model.CustomerOrder;
import com.fuad.test.model.ShippingAddress;
import com.fuad.test.repository.CustomerOrderRepository;
import com.fuad.test.service.CustomerAddressService;
import com.fuad.test.service.CustomerOrderService;
import com.fuad.test.service.CustomerService;
import com.fuad.test.service.EmailSenderService;

@Controller
@RequestMapping("/customer/account")
public class UserAccountController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerAddressService customerAddressService;
    @Autowired
    private CustomerOrderService customerOrderService;
	@Autowired
	private EmailSenderService emailSenderService;

    @RequestMapping
    public String account(HttpServletRequest request, Model model) {

        Long customerId = (Long) request.getSession().getAttribute("customerId_");
        Customer customer = customerService.findOne(customerId);
        model.addAttribute("customer",customer);

//        List<ShippingAddress> customerBillingAddresses = customerAddressRepository.findByIsShippingAndCustomer(false, customer);
        List<ShippingAddress> customerShippingAddresses = customerAddressService.getAllShippingAddressByCustomerId(customerId);
/*
        for(ShippingAddress defaultBillingAddress : customerBillingAddresses){
        	if(defaultBillingAddress.getIsDefault()){
                model.addAttribute("billingAddress",customerBillingAddresses);
        	}
        }*/
        for(ShippingAddress defaultShippingAddress : customerShippingAddresses){
        	if(defaultShippingAddress.getIsDefault()){
                model.addAttribute("shippingAddress",defaultShippingAddress);
                break;
        	}
        }
        
        if(customerService.hasRole("ROLE_UNAUTH", customer)){
        	model.addAttribute("unAuth", "unAuth");
        }
        
        // Get Customer Orders
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrderByCustomer(customer);
        model.addAttribute("customerOrders", customerOrders);
		

        return "myAccount";
    }
    
    @RequestMapping(value = "/rsac", method = RequestMethod.GET)
	public void resendActiveCode(HttpServletRequest request){
    	Long customerId = (Long) request.getSession().getAttribute("customerId_");
        Customer customer = customerService.findOne(customerId);
		if(customer != null){
			if(!customerService.hasRole("ROLE_USER", customer))
				emailSenderService.sendActiveCode(customer);
		}
	}
}

