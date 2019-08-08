package com.scerp.salesdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scerp.salesdepartment.domain.ToDoEvent;


@Repository
public interface ToDoRepository extends CrudRepository<ToDoEvent, Long> {
}