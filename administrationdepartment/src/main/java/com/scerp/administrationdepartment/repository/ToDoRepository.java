package com.scerp.administrationdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scerp.administrationdepartment.domain.EmployeeEntity;
import com.scerp.administrationdepartment.domain.ToDoEvent;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoEvent, Long> {

}