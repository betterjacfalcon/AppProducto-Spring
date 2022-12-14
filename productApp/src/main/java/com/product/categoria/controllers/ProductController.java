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

import com.product.categoria.entities.Product;
import com.product.categoria.services.ProductoService;

@RequestMapping()
@RestController
public class ProductController {

	@Autowired
	private ProductoService productService;
	
	@PostMapping ("/categories/{categoryId}")
	public ResponseEntity<Product> create(@PathVariable("categoryId") Integer categoryId, @RequestBody Product product){
		return new ResponseEntity<Product>(productService.create(categoryId,  product), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/categories/{categoryId}/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("categoryId") Integer categoryId, @PathVariable("productId") Integer productId, @RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.updateProduct(categoryId, productId, product), HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("productId") Integer productId){
		productService.deleteProduct(productId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/categories/{categoryId}")	
	public ResponseEntity<List<Product>> getCategories(@PathVariable("categoryId") Integer categoryId){
		
		return new ResponseEntity<List<Product>>(productService.getCategories(categoryId),HttpStatus.OK);
	}
	
	@GetMapping("/description/{descriptionId}")	
	public ResponseEntity<List<Product>> getDescription(@PathVariable("descriptionId") String descriptionId){
		
		return new ResponseEntity<List<Product>>(productService.getDescriptionId(descriptionId),HttpStatus.OK);
	}
	
	
}
