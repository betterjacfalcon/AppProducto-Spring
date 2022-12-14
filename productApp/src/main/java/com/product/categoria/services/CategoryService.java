package com.product.categoria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.product.categoria.entities.Categories;
import com.product.categoria.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;	
	
	public Categories createCategories(Categories categories) {		
		return repository.save(categories);
	}
	
	public Categories updateCategory(Integer categoryId, Categories categories) {
		Optional<Categories> result = repository.findById(categoryId);		
		if(result.isPresent()) {
			return repository.save(categories);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category %d doesn't exists", categoryId));
		}
	}
	
	public void deleteCategory(Integer categoryId) {
		Optional<Categories> result = repository.findById(categoryId);		
		if(result.isPresent()) {
			 repository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category id %d doesn't exists", categoryId));
		}
		
	}
	
	public List<Categories> getDescriptionId(String descriptionId){		
		return repository.findByDescriptionId(descriptionId);
	}

}
