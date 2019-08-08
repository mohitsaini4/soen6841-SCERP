package com.scerp.administrationdepartment.repository;

import org.springframework.data.repository.CrudRepository;

import com.scerp.administrationdepartment.domain.AdminEntity;

public interface AdminRepository extends CrudRepository<AdminEntity, Long>{
	AdminEntity findByUsername(String username);
}
