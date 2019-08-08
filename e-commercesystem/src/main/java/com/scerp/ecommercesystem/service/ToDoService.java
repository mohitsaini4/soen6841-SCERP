package com.scerp.ecommercesystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import com.scerp.ecommercesystem.domain.CustomerEntity;
import com.scerp.ecommercesystem.domain.ToDoEvent;
import com.scerp.ecommercesystem.repository.CustomerRepository;
import com.scerp.ecommercesystem.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public String addCustomerService(CustomerEntity customerInfo) {
		Optional<CustomerEntity> query = customerRepository.findByUsername(customerInfo.getUsername());
		if(query.isPresent()) {
			return "Username Already Exist";
		}
		else {
		customerRepository.save(customerInfo);
		return "Customer added";
		}
	}
	
	
	public String deleteCustomerService(CustomerEntity customerInfo) {
		customerRepository.deleteByUsername(customerInfo.getUsername());
		return "Customer Deleted";
	}
	
	
	public String customerLoginService(CustomerEntity customerEntity) {
		Optional<CustomerEntity> customer = customerRepository.findByUsername(customerEntity.getUsername());
		if(customer.isPresent()) {
		if (customer.get().getPassword().equals(customerEntity.getPassword()))
			return "Login Successful";
		else
			return "Login Un-successful";
		}
		else return "invalid username";
	}
	
	
	public String modifyCustomerDetailsService(CustomerEntity customerInfo) {
		customerRepository.setNewCustomerDetailsForCustomer(customerInfo.getName(), customerInfo.getAddress(), customerInfo.getPhoneNo() );
		return "Customer Details Modified";
	}
	
	
	public CustomerEntity findByUsernameService(String username) {
		Optional<CustomerEntity> customer = customerRepository.findByUsername(username);
		System.out.println(customer.toString());
		return customer.get();
	}
	
	
	public String getProductsService() {
		ResponseEntity<String> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8088/sales/getProducts", String.class);
		return responseEntity.getBody();
	}

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

}