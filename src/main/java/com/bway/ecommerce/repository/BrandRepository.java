package com.bway.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerce.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
