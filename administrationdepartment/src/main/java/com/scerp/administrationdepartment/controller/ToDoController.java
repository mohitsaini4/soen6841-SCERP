package com.scerp.administrationdepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scerp.administrationdepartment.domain.AdminEntity;
import com.scerp.administrationdepartment.domain.EmployeeEntity;
import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.service.ToDoService;

@RestController
@RequestMapping("/")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	
	

	@GetMapping
	public Iterable<ToDoEvent> getToDoEvent() {
		return toDoService.getAllnonDoneEvents();
	}


	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeEntity employeeInfo) {
		return toDoService.addEmployeeService(employeeInfo);
	}
	

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@RequestBody EmployeeEntity employeeInfo) {
		return toDoService.deleteEmployeeService(employeeInfo);
	}
	
	@RequestMapping(value = "/modifyEmployee", method = RequestMethod.POST)
	public String modifyEmployee(@RequestBody EmployeeEntity employeeInfo) {
		return toDoService.modifyEmployeeService(employeeInfo);
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@RequestBody AdminEntity adminEntity) {
		return toDoService.adminLoginService(adminEntity);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/checkSalesAuthorization/{name}/{pass}")
	@ResponseBody
	public String checkSalesAuthorization(@PathVariable() String name,@PathVariable() String pass) {
		return toDoService.checkSalesAuthorizationService(name,pass);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/checkCrAuthorization/{name}/{pass}")
	@ResponseBody
	public String checkCrAuthorization(@PathVariable() String name,@PathVariable() String pass) {
		return toDoService.checkCrAuthorizationService(name,pass);
	}
	
}