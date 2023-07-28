package com.bway.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
