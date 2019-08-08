package com.scerp.administrationdepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scerp.administrationdepartment.domain.AdminEntity;
import com.scerp.administrationdepartment.domain.EmployeeEntity;
import com.scerp.administrationdepartment.domain.ToDoEvent;
import com.scerp.administrationdepartment.repository.ToDoRepository;
import com.scerp.administrationdepartment.repository.AdminRepository;
import com.scerp.administrationdepartment.repository.EmployeeRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository todoRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	public Iterable<ToDoEvent> getAllnonDoneEvents() {
		return todoRepository.findAll();
	}

	public String addEmployeeService(EmployeeEntity employeeInfo) {
		AdminEntity admin = adminRepository.findByUsername(employeeInfo.getAdminName());
		if(admin.getIsAdmin()==true)
		{
			System.out.println(employeeInfo.getFirstName());
			System.out.println(employeeInfo.getLastName());
			System.out.println(employeeInfo.getPassword());
			System.out.println(employeeInfo.getUsername());
			System.out.println(employeeInfo.getAddress());
			System.out.println(employeeInfo.getDesignation());
			System.out.println(employeeInfo.getEmployeeType());
			System.out.println(employeeInfo.getPhoneNum());
			System.out.println(employeeInfo.getSin());
			employeeRepository.save(employeeInfo);
			return "Employee added";
		}
		else
			return "Unauthorized access";
	}

	public String deleteEmployeeService(EmployeeEntity employeeInfo) {
		AdminEntity admin = adminRepository.findByUsername(employeeInfo.getAdminName());
		if(admin.getIsAdmin()==true)
		{
			System.out.println(employeeInfo.getFirstName());
			System.out.println(employeeInfo.getLastName());
			System.out.println(employeeInfo.getPassword());
			System.out.println(employeeInfo.getUsername());
			System.out.println(employeeInfo.getAddress());
			System.out.println(employeeInfo.getDesignation());
			System.out.println(employeeInfo.getEmployeeType());
			System.out.println(employeeInfo.getPhoneNum());
			System.out.println(employeeInfo.getSin());
			employeeRepository.deleteByUsername(employeeInfo.getUsername());
			return "Employee Deleted";
		}
		else
			return "Unauthorized access";

	}

	public String modifyEmployeeService(EmployeeEntity employeeInfo) {
		AdminEntity admin = adminRepository.findByUsername(employeeInfo.getAdminName());
		if(admin.getIsAdmin()==true)
		{
			System.out.println(employeeInfo.getFirstName());
			System.out.println(employeeInfo.getLastName());
			System.out.println(employeeInfo.getPassword());
			System.out.println(employeeInfo.getUsername());
			System.out.println(employeeInfo.getAddress());
			System.out.println(employeeInfo.getDesignation());
			System.out.println(employeeInfo.getEmployeeType());
			System.out.println(employeeInfo.getPhoneNum());
			System.out.println(employeeInfo.getSin());
			employeeRepository.deleteByUsername(employeeInfo.getUsername());
			employeeRepository.save(employeeInfo);
			return "Employee Info Modified";
		}
		else
			return "Unauthorized access";

	}

	public String adminLoginService(AdminEntity adminEntity) {
		adminRepository.save(adminEntity);
		AdminEntity admin = adminRepository.findByUsername(adminEntity.getUsername());
		admin.setIsAdmin(true);
		adminRepository.save(admin);
		if (admin.getPassword().equals(adminEntity.getPassword()))
			return "Login Successful";
		else
			return "Login Un-successful";
	}
	
	public String checkSalesAuthorizationService(String username, String password)
	{
		EmployeeEntity employee = employeeRepository.findByUsername(username);
		if(employee.getPassword().equals(password)&& employee.getEmployeeType().equals("Sales"))
		return "Login Successful";
		else
		return "Unauthorized access";
	}
	
	public String checkCrAuthorizationService(String username, String password)
	{
		EmployeeEntity employee = employeeRepository.findByUsername(username);
		if(employee.getPassword().equals(password)&& employee.getEmployeeType().equals("CR"))
		return "Login Successful";
		else
		return "Unauthorized access";
	}

}