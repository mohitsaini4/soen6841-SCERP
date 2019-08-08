package com.scerp.administrationdepartment.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.administrationdepartment.domain.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	@Modifying
	@Transactional
	void deleteByUsername(String firstName);

	EmployeeEntity findByUsername(String username);
}
