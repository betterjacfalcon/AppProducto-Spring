package com.product.categoria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.categoria.entities.Categories;


@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer>{
	@Query("SELECT c  FROM Categories c   WHERE description=?1")
	List<Categories> findByDescriptionId(String descriptionId);
}
