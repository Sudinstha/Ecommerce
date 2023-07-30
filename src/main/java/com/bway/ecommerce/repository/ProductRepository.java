package com.bway.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerce.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
