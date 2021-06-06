package team5.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import team5.model.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
	
	@Query("Select s from Supplier s where s.supplierName = :snm")
	List<Supplier> findByName(@Param("snm")String name);
}
