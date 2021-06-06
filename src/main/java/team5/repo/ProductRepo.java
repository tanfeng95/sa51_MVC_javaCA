package team5.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import team5.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product>{
	
	@Query("Select s from Product s where s.name = :nm")
	List<Product> findByName(@Param("nm")String name);

    @Query("SELECT DISTINCT p FROM Product p  WHERE p.partNumber LIKE :Partnum%")
    @Transactional(readOnly = true)
    Collection<String> findByPartNumber(@Param("Partnum") String partNumber);
   

    @Query("SELECT p FROM Product p WHERE p.partNumber LIKE %?1%"
            + " OR p.description LIKE %?1%"
            + " OR p.color LIKE %?1%")
    public List<Product> searchpart(String keyword);
	
	@Query("Select p from Product as p where p.name LIKE %?1%" + " OR p.description LIKE %?1%" + " OR p.barcode LIKE %?1%"
			+ " OR p.type LIKE %?1%" + " OR p.color LIKE %?1%" + " OR p.originalPrice LIKE %?1%" + " OR p.category LIKE %?1%"
			+ " OR p.priceFWholesale LIKE %?1%" + " OR p.priceFRetail LIKE %?1%" + " OR p.PriceFPartner LIKE %?1%"			
			+ " OR p.subcategory LIKE %?1%" + " OR p.unit LIKE %?1%" + " OR p.partNumber LIKE %?1%" + " OR p.reorderLevel LIKE %?1%"
			+ " OR p.minReoderLevel LIKE %?1%")
	public List<Product> search(String keyword);
	
	@Modifying
	@Query("Update Product p set p.unit=p.unit - :quan where p.id=:pid and p.unit > 0 and p.unit >= :quan")
	public void reduceStock(@Param("quan")Long quantity,@Param("pid")Long id);
	
	public Product findById(long a);
	//public ArrayList<Product> findAll();
	
	@Query(value = "SELECT * FROM product WHERE name LIKE %?1% OR description LIKE %?1% "
			+ " OR barcode LIKE %?1% OR category LIKE %?1%"
			+ " OR type LIKE %?1% OR color LIKE %?1% "
//			+ " OR originalPrice LIKE %?1% OR partNumber LIKE %?1% OR reorderLevel LIKE %?1% OR minReoderLevel LIKE %?1% "
			+ " OR priceFWholesale LIKE %?1% OR priceFRetail LIKE %?1% OR PriceFPartner LIKE %?1% "
			+ " OR subcategory LIKE %?1% OR unit LIKE %?1% ",
//			Cannot search originalPrice, Part Number, Reorder Level, minReorderLevel,
			countQuery = "SELECT count(*) FROM product WHERE name LIKE %?1% Or description LIKE %?1% "
					+ " OR barcode LIKE %?1% OR category LIKE %?1%"
					+ " OR type LIKE %?1% OR color LIKE %?1% "
//					+ " OR originalPrice LIKE %?1% OR partNumber LIKE %?1% OR reorderLevel LIKE %?1% OR minReoderLevel LIKE %?1% "
					+ " OR priceFWholesale LIKE %?1% OR priceFRetail LIKE %?1% OR PriceFPartner LIKE %?1% "
					+ " OR subcategory LIKE %?1% OR unit LIKE %?1% ",
			nativeQuery = true)
	public Page<Product> search2(String keyword, Pageable pageable);
}
