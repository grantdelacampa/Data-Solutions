package com.myproject.datasolutions.assets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * Extends the JpaRepository from spring data JPA
 * Inherited: count, delete, deleteAll, deleteAll, deleteById, existsById, findById, save
 * Domain Type: asset
 * Id type: Integer
 */
public interface AssetRepository extends JpaRepository<Asset,Integer> {

	//Reference: https://www.springboottutorial.com/introduction-to-jpa-with-spring-boot-data-jpa
	@Query("SELECT COUNT(a) FROM Asset a WHERE a.status = ?1")
	int countByStatus(String status);
	
	@Query("SELECT COUNT(a) FROM Asset a WHERE a.ast_type = ?1")
	int countByType(String type);
}
