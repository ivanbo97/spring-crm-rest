package com.luv2code.springdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@Component
public class CheckCustomer {

	@Autowired 
	private CustomerService customerService;
	
	public  void existence (int customerId) {
			
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer with id= " + customerId + " was not found.");
		}
	}
}
