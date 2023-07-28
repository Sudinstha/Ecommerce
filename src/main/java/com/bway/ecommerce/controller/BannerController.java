package com.bway.ecommerce.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bway.ecommerce.Utils.FileUtils;
import com.bway.ecommerce.model.Banner;
import com.bway.ecommerce.service.BannerService;

@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private FileUtils fileUtil;
	@Autowired
	private BannerService bannerService;
	
	@GetMapping("/add")
	public String getBanner(Model model,HttpSession session) {
		
		String[] imageNames = new File("src/main/resources/static/images/banner").list();
		model.addAttribute("imgNameList",imageNames);
		return "banneradd";
	}
	
	@PostMapping("/add")
	public String postBanner(@ModelAttribute Banner banner,@RequestParam MultipartFile photo ) {

		if(!photo.isEmpty()) {
			banner.setImage(photo.getOriginalFilename());
			fileUtil.fileUploadBanner(photo);
		}

		bannerService.addBanner(banner);
		return "banneradd";
	}
	@GetMapping("/list")
	public String bannerList(Model model) {
		model.addAttribute("bannerList", bannerService.getAllBanners());
	return "bannerlist";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam long id, Model model){
		model.addAttribute("bannerObject", bannerService.getBannerById(id));
		return "banneredit";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		bannerService.deleteBanner(id);
		return "redirect:/banner/list";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Banner banner) {
		 bannerService.updateBanner(banner);
		 return "redirect:/banner/list";
	}
	
}
