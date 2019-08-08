package com.scerp.ecommercesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.scerp.ecommercesystem.domain.CustomerEntity;
import com.scerp.ecommercesystem.domain.ToDoEvent;
import com.scerp.ecommercesystem.service.ToDoService;



@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	

	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}
	
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestBody CustomerEntity customerInfo) {
		return toDoService.addCustomerService(customerInfo);
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public String deleteCustomer(@RequestBody CustomerEntity customerInfo) {
		return toDoService.deleteCustomerService(customerInfo); 
	}
	
	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public String customerLogin(@RequestBody CustomerEntity customerEntity) {
		return toDoService.customerLoginService(customerEntity);
	}
	
	@RequestMapping(value = "/modifyCustomerDetails")
	public String modifyCustomerDetails(@RequestBody CustomerEntity customerInfo) {
		return toDoService.modifyCustomerDetailsService(customerInfo);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findByUserName/{username}")
	@ResponseBody
	public CustomerEntity findByUsername(@PathVariable() String username) {
		return toDoService.findByUsernameService(username);
	}
	
	@GetMapping
	@RequestMapping("/getProducts")
	public String getProducts() {
		return toDoService.getProductsService();
	}
	
}