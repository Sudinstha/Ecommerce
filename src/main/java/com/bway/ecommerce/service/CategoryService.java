package com.bway.ecommerce.service;

import java.util.List;

import com.bway.ecommerce.model.Category;

public interface CategoryService {

	void addCategory(Category cat);
	void deleteCat(long id);
	void updateCat(Category cat);
	Category getCatById(long id);
	List<Category> getAllCats();
}
