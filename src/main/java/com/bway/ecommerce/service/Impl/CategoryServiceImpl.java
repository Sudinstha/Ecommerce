package com.bway.ecommerce.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerce.model.Category;
import com.bway.ecommerce.repository.CategoryRepository;
import com.bway.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catRepo;
	@Override
	public void addCategory(Category cat) {
		
		catRepo.save(cat);
	}

	@Override
	public void deleteCat(long id) {
		catRepo.deleteById(id);
		
	}

	@Override
	public void updateCat(Category cat) {
		catRepo.save(cat);
		
	}

	@Override
	public Category getCatById(long id) {
		
		return catRepo.findById(id).get();
	}

	@Override
	public List<Category> getAllCats() {
		
		return catRepo.findAll();
	}

}
