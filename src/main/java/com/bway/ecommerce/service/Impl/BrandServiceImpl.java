package com.bway.ecommerce.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerce.model.Brand;
import com.bway.ecommerce.repository.BrandRepository;
import com.bway.ecommerce.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepo;
	@Override
	public void addBrand(Brand brand) {
		brandRepo.save(brand);
		
	}

	@Override
	public void deleteBrand(long id) {
		brandRepo.deleteById(id);
		
	}

	@Override
	public void updateBrand(Brand brand) {
		brandRepo.save(brand);
		
	}

	@Override
	public Brand getBrandById(long id) {

		return brandRepo.findById(id).get();
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandRepo.findAll();
	}

}
