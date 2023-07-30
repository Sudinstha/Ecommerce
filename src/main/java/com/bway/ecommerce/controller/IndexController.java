package com.bway.ecommerce.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bway.ecommerce.service.CategoryService;
import com.bway.ecommerce.service.ProductService;

@Controller
public class IndexController {
   @Autowired
	CategoryService catService;
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String getIndex(Model model) {
	  model.addAttribute("categories", catService.getAllCats());
	  model.addAttribute("products", productService.getAllProducts());
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model) {
		 model.addAttribute("categories", catService.getAllCats());
		  model.addAttribute("products", productService.getAllProducts());
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable Long id) {
		  model.addAttribute("product", productService.getProductById(id));
		return "viewProduct";
	}
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
	
	
}
