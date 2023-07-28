package com.bway.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerce.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {

}
