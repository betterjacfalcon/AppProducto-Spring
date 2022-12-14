package com.product.categoria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.product.categoria.entities.Product;
import com.product.categoria.entities.ProductDetail;
import com.product.categoria.repositories.ProductDetailRepository;
import com.product.categoria.repositories.ProductRepository;

@Service
public class ProductDetailService {
	
	@Autowired
	private ProductRepository productoRepository;
	
	@Autowired
	private ProductDetailRepository productoDetailRepository;  
	
public ProductDetail create(Integer productoId, ProductDetail productDetail) {
		
		Optional<Product> result = productoRepository.findById(productoId);		
				
		if (result.isPresent()) {			
			productDetail.setProduct(result.get()); 
			return productoDetailRepository.save(productDetail);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Producto id %d doesn't exists", productoId)); 
		}			
		
	}

}
