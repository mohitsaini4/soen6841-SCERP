package com.scerp.customerservicedepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scerp.customerservicedepartment.domain.ToDoEvent;


@Repository
public interface ToDoRepository extends CrudRepository<ToDoEvent, Long> {
	
}