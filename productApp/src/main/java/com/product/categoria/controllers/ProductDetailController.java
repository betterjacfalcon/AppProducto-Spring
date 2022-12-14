package com.product.categoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.categoria.entities.ProductDetail;
import com.product.categoria.services.ProductDetailService;


@RequestMapping()
@RestController
public class ProductDetailController {
	
	@Autowired
	private ProductDetailService productDetailService;
	
	@PostMapping ("/productoDetalle/{productId}")
	public ResponseEntity<ProductDetail> create(@PathVariable("productId") Integer productId, @RequestBody ProductDetail productDetail){
		return new ResponseEntity<ProductDetail>(productDetailService.create(productId,  productDetail), HttpStatus.CREATED); 
		
	}
	
	

}
