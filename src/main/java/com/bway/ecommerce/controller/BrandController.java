package com.bway.ecommerce.controller;



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
import com.bway.ecommerce.model.Brand;
import com.bway.ecommerce.service.BrandService;


@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private FileUtils fileUtil;

	
	  @Autowired 
	  private BrandService brandService;
	 
	@GetMapping("/add")
	public String getBrand() {
		return "brandadd";
	}
	
	@PostMapping("/add")
	public String postBrand(@ModelAttribute Brand brand,@RequestParam MultipartFile photo ) {

		if(!photo.isEmpty()) {
			brand.setImage(photo.getOriginalFilename());
			fileUtil.fileUploadBrand(photo);
		}

		brandService.addBrand(brand);
		return "brandadd";
	}
	@GetMapping("/list")
	public String brandList(Model model) {
		model.addAttribute("brandList", brandService.getAllBrands());
	return "brandlist";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam long id, Model model){
		model.addAttribute("brandObject", brandService.getBrandById(id));
		return "brandedit";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		brandService.deleteBrand(id);
		return "redirect:/brand/list";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Brand brand) {
		 brandService.updateBrand(brand);
		 return "redirect:/brand/list";
	}
}
