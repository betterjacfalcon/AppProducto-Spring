package com.product.categoria.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.categoria.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p  FROM Product p Join Fetch p.categories categories  WHERE categories.id=?1 AND p.id=?2")
	Optional <Product> findByCategoriesIdAndProductId(Integer categoryId, Integer productId);
	
	@Query("SELECT p  FROM Product p Join Fetch p.categories categories  WHERE categories.id=?1")
	List<Product> findByCategoriesId(Integer categoryId); 
	
	@Query("SELECT p  FROM Product p   WHERE description=?1")
	List<Product> findByDescriptionId(String descriptionId); 
	

	
}
