package com.scerp.customerservicedepartment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.customerservicedepartment.domain.QueryEntity;


@Repository
public interface QueryRepository extends CrudRepository<QueryEntity, Long> {
	

	QueryEntity findByusername(String username);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE QueryEntity q SET q.solution = ?1 WHERE q.username = ?2")
	void setNewQueryDetailsForQuery(String solution, String username);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE QueryEntity q SET q.farwardQueryToSales = ?1 WHERE q.username = ?2")
	void setFarwardQueryToSales(boolean b, String username);

	
	
	Optional <QueryEntity> findById(long parseLong);
	

	

	
}