package com.scerp.salesdepartment.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scerp.salesdepartment.domain.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	@Modifying
	@Transactional
	void deleteByproductId(String productId);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE ProductEntity p SET p.quantity = ?1 WHERE p.productId = ?2")
	int setNewQuantityForProduct(String quantity, String productId);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE ProductEntity p SET p.productName = ?1, p.price = ?2 WHERE p.productId = ?3")
	int setNewProductDetailsForProduct(String productName, String price, String productId);
	
	@Transactional
	ProductEntity findByProductId(String productId);
    
	@Transactional
	Optional<ProductEntity> findByProductName(String productName);
	
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query("UPDATE ProductEntity p SET p.quantity = ?1 WHERE p.productId = ?2")
	int resetInventory(String setQuantity, String id);

	
	
	
}
