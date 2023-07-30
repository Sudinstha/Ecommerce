package com.bway.ecommerce.service;

import java.util.List;

import com.bway.ecommerce.model.Product;



public interface ProductService {

	void addProduct(Product product);
	void deleteProduct(Long id);
	void updateProduct(Product product);
	Product getProductById(Long id);
	List<Product> getAllProducts();
	List<Product> getAllProductsByCategoryId(Long id);
	
}
