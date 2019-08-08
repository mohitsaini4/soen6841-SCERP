package com.scerp.salesdepartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.scerp.salesdepartment.domain.ShipmentEntity;


	
@Repository
public interface ShipmentRepository extends CrudRepository<ShipmentEntity, Long>{


}