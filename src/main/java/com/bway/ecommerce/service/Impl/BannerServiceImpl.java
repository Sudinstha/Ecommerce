package com.bway.ecommerce.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerce.model.Banner;
import com.bway.ecommerce.repository.BannerRepository;
import com.bway.ecommerce.service.BannerService;
 
@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerRepository bannerRepo;
	@Override
	public void addBanner(Banner banner) {
		bannerRepo.save(banner);
		
	}

	@Override
	public void deleteBanner(long id) {
		bannerRepo.deleteById(id);
		
	}

	@Override
	public void updateBanner(Banner banner) {
		bannerRepo.save(banner);
		
	}

	@Override
	public Banner getBannerById(long id) {

		return bannerRepo.findById(id).get();
	}

	@Override
	public List<Banner> getAllBanners() {
		
		return bannerRepo.findAll();
	}

}
