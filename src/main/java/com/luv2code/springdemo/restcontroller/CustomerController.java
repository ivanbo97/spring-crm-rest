package com.luv2code.springdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;



@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer (@PathVariable int customerId) {
		
		return customerService.getCustomer(customerId);
	}
	
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		
		
		// set id 0 forces a save to the new item instead of update 
		// we do this in case the user provides id of the customer
		// the back-end will generate id, there is no use to be set at client level
		newCustomer.setId(0);
		
		customerService.saveCustomer(newCustomer);
		
		return newCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
}
