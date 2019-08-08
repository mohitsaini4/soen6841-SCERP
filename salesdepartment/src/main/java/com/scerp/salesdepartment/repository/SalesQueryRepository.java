package com.scerp.salesdepartment.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.salesdepartment.domain.SalesQueryEntity;


	
@Repository
public interface SalesQueryRepository extends CrudRepository<SalesQueryEntity, Long>{

	SalesQueryEntity findByQueryId(String queryId);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE SalesQueryEntity q SET q.solution = ?1, q.status = ?2 WHERE q.queryId = ?3")
	void setNewQueryDetailsForQuery(String solution, boolean b,String queryId);


}