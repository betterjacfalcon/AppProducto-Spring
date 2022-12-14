package com.product.categoria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.categoria.entities.Categories;
import com.product.categoria.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Categories> createCategory(@RequestBody Categories categories){
		
		return new ResponseEntity<Categories>(categoryService.createCategories(categories), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<Categories> updateCategory(@PathVariable("categoryId") Integer categoryId, @RequestBody Categories categories){
		
		return new ResponseEntity<Categories>(categoryService.updateCategory(categoryId, categories), HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/description/{descriptionId}")	
	public ResponseEntity<List<Categories>> getDescription(@PathVariable("descriptionId") String descriptionId){
		
		return new ResponseEntity<List<Categories>>(categoryService.getDescriptionId(descriptionId),HttpStatus.OK);
	}
}
