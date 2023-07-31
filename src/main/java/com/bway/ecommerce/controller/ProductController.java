package com.bway.ecommerce.controller;

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
import com.bway.ecommerce.model.Product;
import com.bway.ecommerce.service.BrandService;
import com.bway.ecommerce.service.CategoryService;
import com.bway.ecommerce.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private FileUtils fileUtil;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/add")
	public String getProduct(Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		model.addAttribute("catList", catService.getAllCats());
		model.addAttribute("brandList", brandService.getAllBrands());
		return "productadd";
	}
	
	@PostMapping("/add")
	public String postProduct(HttpSession session ,@ModelAttribute Product product, @RequestParam MultipartFile photo) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		if(!photo.isEmpty()) {
			product.setImage(photo.getOriginalFilename());
			fileUtil.fileUploadProduct(photo);
		}
		productService.addProduct(product);
		return "redirect:/product/add";
	}
	@GetMapping("/list")
	public String getAll(Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		model.addAttribute("productList",productService.getAllProducts());
		return "productlist";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		productService.deleteProduct(id);
		return "redirect:/product/list";
	}
	@GetMapping("/edit") 
	public String edit(@RequestParam Long id, Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		model.addAttribute("productObject", productService.getProductById(id));
		model.addAttribute("catList", catService.getAllCats());
		model.addAttribute("brandList", brandService.getAllBrands());
		return "productedit";
	}
	@PostMapping("/update")
	public String update(HttpSession session, @ModelAttribute Product product) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}   
		productService.updateProduct(product);
		 return "redirect:/product/list";
	}
}
