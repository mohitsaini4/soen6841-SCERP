package com.scerp.salesdepartment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.scerp.salesdepartment.domain.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	OrderEntity findByProductId(String productId);

	void deleteByCustomerUsername(String customerUsername);

	OrderEntity findById(long parseLong);

	

}
