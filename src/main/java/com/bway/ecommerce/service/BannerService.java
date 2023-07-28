package com.bway.ecommerce.service;

import java.util.List;

import com.bway.ecommerce.model.Banner;

public interface BannerService {
	void addBanner(Banner banner);
	void deleteBanner(long id);
	void updateBanner(Banner banner);
	Banner getBannerById(long id);
	List<Banner> getAllBanners();
}
