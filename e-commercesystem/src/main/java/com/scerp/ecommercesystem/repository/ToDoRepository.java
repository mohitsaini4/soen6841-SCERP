package com.scerp.ecommercesystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scerp.ecommercesystem.domain.ToDoEvent;


@Repository
public interface ToDoRepository extends CrudRepository<ToDoEvent, Long> {
}