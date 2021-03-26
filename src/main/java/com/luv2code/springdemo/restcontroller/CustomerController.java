package com.luv2code.springdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.CheckCustomer;



@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CheckCustomer checkCustomer;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer (@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		checkCustomer.existence(customerId);
		
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
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		checkCustomer.existence(customerId);
		
		customerService.deleteCustomer(customerId);
	}
	
}
