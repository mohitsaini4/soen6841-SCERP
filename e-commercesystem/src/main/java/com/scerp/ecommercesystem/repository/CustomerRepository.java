package com.scerp.ecommercesystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.ecommercesystem.domain.CustomerEntity;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	@Transactional
	void deleteByUsername(String username);
	
	Optional<CustomerEntity> findByUsername(String username);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE CustomerEntity c SET c.name = ?1, c.address = ?2 WHERE c.phoneNo = ?3")
	int setNewCustomerDetailsForCustomer(String name, String address, String phoneNo);
}