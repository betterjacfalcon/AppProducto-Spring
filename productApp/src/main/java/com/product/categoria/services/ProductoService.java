package com.product.categoria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.product.categoria.entities.Categories;
import com.product.categoria.entities.Product;
import com.product.categoria.repositories.CategoryRepository;
import com.product.categoria.repositories.ProductRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductRepository productoRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	public Product create(Integer categoryId, Product product) {
		
		Optional<Categories> result = categoryRepository.findById(categoryId);		
				
		if (result.isPresent()) {			
			product.setCategories(result.get());
			return productoRepository.save(product);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category id %d doesn't exists", categoryId));
		}			
		
	}
	
	public Product updateProduct(Integer categoryId,Integer productId, Product product) {
		Optional<Product> result = productoRepository.findByCategoriesIdAndProductId(categoryId, productId);
		Optional<Categories> resultCat = categoryRepository.findById(categoryId);
		if(result.isPresent()) {
			product.setCategories(resultCat.get());
			return productoRepository.save(product);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product %d doesn't exists", categoryId, productId));
		}
	}
	
	public void deleteProduct(Integer productId) {
		Optional<Product> result = productoRepository.findById(productId);		
		if(result.isPresent()) {
			productoRepository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product id %d doesn't exists", productId));
		}
		
	}
	
	public List<Product> getCategories(Integer categoryId){		
		return productoRepository.findByCategoriesId(categoryId);
	}
	
	public List<Product> getDescriptionId(String descriptionId){		
		return productoRepository.findByDescriptionId(descriptionId);
	}
	
	
	
}
