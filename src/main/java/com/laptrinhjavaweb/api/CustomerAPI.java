package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.ICustomerService;

@RestController

public class CustomerAPI {
	@Autowired
	private ICustomerService customerService;


	@RequestMapping(value = "/api/customer/insert", method = RequestMethod.POST)
	public CustomerDTO createdUser(@RequestBody CustomerDTO customerDTO){
		return customerService.save(customerDTO);
	}
	@RequestMapping(value = "/api/customer/edit", method = RequestMethod.PUT)
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
		return customerService.update(customerDTO);
	}
	@RequestMapping(value = "/api/customer/delete", method = RequestMethod.DELETE)
	public void deleteCustomer(@RequestBody CustomerDTO customerDTO){
		customerService.deleteMany(customerDTO);
	}

}
