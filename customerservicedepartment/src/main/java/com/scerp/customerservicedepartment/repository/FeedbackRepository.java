package com.scerp.customerservicedepartment.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.customerservicedepartment.domain.FeedbackEntity;



@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Long> {

	FeedbackEntity findById(Long id);
	

	
}