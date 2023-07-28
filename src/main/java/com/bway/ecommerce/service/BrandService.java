package com.bway.ecommerce.service;

import java.util.List;

import com.bway.ecommerce.model.Brand;

public interface BrandService {

	void addBrand(Brand brand);
	void deleteBrand(long id);
	void updateBrand(Brand brand);
	Brand getBrandById(long id);
	List<Brand> getAllBrands();
}
