package com.bway.ecommerce.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerce.model.Product;
import com.bway.ecommerce.repository.ProductRepository;
import com.bway.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public void updateProduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public Product getProductById(Long id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
		}

}
